package Biblioteca;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import DateUtility.DateUtility;

public class Gestione {
	
	/* NON HA ATTRIBUTI. 
	 * CONTIENE I METODI PER GESTIRE LA BIBLIOTECA
	 * IL COSTRUTTORE VUOTO E' DI DEFAULT QUINDI POSSIAMO NON SCRIVERLO
	 */
	
	/* REGISTRA IL LIBRO SE NON E' PRESENTE NELLA MAPPA LIBRI,
	 * ALTRIMENTI AGGIORNA LE COPIE.
	 * RITORNRA IL LIBRO REGISTRATO.
	 */
	public Libro registraLibro(Biblioteca b, String titolo, String autore, String serialNum, int copie){
		Libro l = null;
		l = b.getMappaLibri().get(serialNum);
		
		if(l != null){
			l.setCopieTotali(l.getCopieTotali()+copie);
			l.setCopieDisponibili(l.getCopieDisponibili()+copie);
		}else{
			l = new Libro(titolo,autore,serialNum);
			
			l.setCopieTotali(copie);
			l.setCopieDisponibili(copie);
			
			b.aggiungiLibro(l);
		}
		return l;	
	}
	
	/* REGISTRA L'UTENTE 
	 * SE NON E' PRESENTE NELLA MAPPA UTENTI DI BIBLIOTECA LANCIA ECCEZIONE
	 * ALTRIMENTI REGISTRA E RITORNA L'UTENTE REGISTRATO
	 */
	public Utente registraUtente(Biblioteca b, String nome, String cognome, String codiceFiscale)throws UtenteGiaEsiste{
		
		if(b.getMappaUtenti().containsKey(codiceFiscale)){
			throw new UtenteGiaEsiste("Esiste in biblioteca "+b.getNome());
		}
		
		Utente u = new Utente(nome,cognome,codiceFiscale);
		
		b.aggiungiUtente(u);
		
		return u;
	}
	
	
	/* SE IL LIBRO ESISTE, SE L'UTENTE ESISTE,
	 * SE CI SONO COPIE DISPONIBILI E SE L'UTENTE NON HA SUPERATO IL NUMERO MASSIMO DI LIBRI 
	 * CHE PUO' AVERE IN PRESTITO, IL METODO CHIAMA IL "CREAPRESTITO" E RITORNA TRUE
	 * ALTRIMENTI IL PRESTITO NON AVVIENE E RITORNA FALSE
	 */
	public boolean prestaLibro(Biblioteca b, String serialNum, String codiceFiscale){
		
		boolean result = false;
		Prestito p = null;
		
		Libro l = null;
		l = b.getMappaLibri().get(serialNum);
		
		Utente u = null;
		u = b.getMappaUtenti().get(codiceFiscale);
		
		if(l != null && u != null && u.getNumeroLibri() < 3 && l.getCopieDisponibili() > 0){
			p = creaPrestito(l,u);
			b.getMappaPrestiti().put(l.getSerialNum(), p);
			result = true;
		}
		
		return result;
	}
	
	/* CREO UN OGGETTO PRESTITO CHE INIZIALIZZA LA DATA DEL PRESTITO E LA DATA DI SCADENZA
	 * AGGIORNA LA LISTA LIBRI UTENTE E RITORNA IL PRESTITO CREATO
	 */
	private Prestito creaPrestito(Libro l, Utente u){
		Prestito pTemp = null;
		DateUtility dt = new DateUtility();
		
		Date data = new Date(); // ASSEGNA LA DATA DI OGGI
		
		Calendar calendarCorrente = new GregorianCalendar();
		calendarCorrente.setTime(data); // DATA DI OGGI 
		Date dataCorrente = dt.convertCalendarToJavaDate(calendarCorrente); // CONVERTE DATA DA CALENDAR A DATE
		
		Calendar calendarScadenza = calendarCorrente;
		calendarScadenza.add(Calendar.MONTH, 1); // SET DATA DI OGGI AL MESE SUCCESSIVO
		Date dataScadenza = dt.convertCalendarToJavaDate(calendarScadenza); // CONVERTE DA DA CALENDAR A DATE
		
		u.getLibri().put(l.getSerialNum(), l);
		pTemp = new Prestito(l,u,dataCorrente,dataScadenza);	
		
		return pTemp;
	} 
	
	/* SE ESISTONO IL LIBRO E L'UTENTE, 
	 * CONTROLLO LA DIFFERENZA GIORNI, SE RISPETTA LA SCADENZA 
	 * RESTITUISCE TRUE
	 * ALTRIMENTI FALSE
	 */
	public boolean restituzioneLibro(Biblioteca b, String serialNum, String codiceFiscale){
		boolean restituzione = false;
		DateUtility dt = new DateUtility();
		
		Libro l = b.getMappaLibri().get(serialNum);
		Utente u = b.getMappaUtenti().get(codiceFiscale);
		
		Date dataOggi = new Date(); // DATA DI OGGI
		Date dataRestituzione = b.getMappaPrestiti().get(serialNum).getDataRestituzione(); // DATA RESTITUZIONE DI L
		long dayDiff = dt.getDayDifference(dataOggi, dataRestituzione); // CALCOLO DIFFERENZA DATE
		
		if(l != null && u != null && dayDiff > 0)
		{
			restituzione = true;
			u.getLibri().remove(l); // RIMUOVE DALLA MAPPA LIBRI DELL'UTENTE
			l.setCopieDisponibili(l.getCopieDisponibili()+1); // AGGIORNA COPIE DISPONIBILI LIBRO
			b.getMappaPrestiti().remove(l.getSerialNum()); // RIMUOVE PRESTITO DALLA MAPPA PRESTITI
		
		}else
		{
			restituzione = false;
			u.getLibri().remove(l); // RIMUOVE DALLA MAPPA LIBRI DELL'UTENTE
			l.setCopieDisponibili(l.getCopieDisponibili()+1); // AGGIORNA COPIE DISPONIBILI LIBRO
			b.getMappaPrestiti().remove(l.getSerialNum()); // RIMUOVE PRESTITO DALLA MAPPA PRESTITI
		}
		
		return restituzione;
	}
	

}
