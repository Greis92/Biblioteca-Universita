package Main;

import Università.Corso;
import Università.Docente;
import Università.Segreteria;
import Università.Studente;
import Università.Università;
import Biblioteca.Biblioteca;
import Biblioteca.Gestione;
import Biblioteca.UtenteGiaEsiste;

public class testBiblioteca {

	public static void main(String[] args) {
		
		// PROVA METODI GESTIONE BIBLIOTECA
		
		Gestione g = new Gestione(); // CREO LA GESTIONE DELLA BIBLIOTECA
		Biblioteca b = new Biblioteca(); // CREO LA BIBLIOTECA
			

		//PROVA REGISTRA LIBRO    OK!!!
		System.out.println(g.registraLibro(b,"I Pilastri Della Terra","Ken Follett","001",2).toStringLibro());
		//System.out.println(g.registraLibro(b,"I Pilastri Della Terra","Ken Follett","001",2).toStringLibro());
		System.out.println(g.registraLibro(b,"Il Mondo Senza Fine","Ken Follett","003",2).toStringLibro());
		
		//STAMPA MAPPA LIBRI BIBLIOTECA
		//System.out.println(b.toStringLibri());
		
		
		//PROVA REGISTRA UTENTE   OK!!!
		try{
			
			g.registraUtente(b, "Paolo", "Villa", "PV");
			//g.registraUtente(b, "Paolo", "Villa", "PV"); PROVA UTENTE DOPPIO
			g.registraUtente(b, "Luciana", "Neri", "LN");
			
		}catch(UtenteGiaEsiste e){
			System.out.println("Utente esistente!");
		} 
		
		//STAMPA MAPPA UTENTI BIBLIOTECA
		//System.out.println(b.toStringUtenti());
		
		//PROVA PRESTALIBRO       OK!!!
		System.out.println("Prestito riuscito? " + g.prestaLibro(b, "001", "PV")); // TRUE
		System.out.println("Prestito riuscito? " + g.prestaLibro(b, "005", "LN")); // FALSE
		System.out.println("Prestito riuscito? " + g.prestaLibro(b, "003", "LN")); // TRUE
		
		System.out.println();
		
		//STAMPA MAPPA LIBRI DI UN UTENTE
		//System.out.println(b.getMappaUtenti().get("PV").toStringMappaLibri());
		
		//VISUALIZZA PRESTITO
		System.out.println(b.toStringPrestiti());
		
		System.out.println();
		
		//PROVA RESTITUZIONE      OK!!!
		System.out.println("Restituzione avvenuta prima della scadenza? " + g.restituzioneLibro(b, "001", "PV"));
		System.out.println("Restituzione avvenuta prima della scadenza? " + g.restituzioneLibro(b, "003", "LN"));
		
		//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//*//
		System.out.println();
		
		//PROVA METODI SEGRETERIA UNIVERSITA'
		
		//CREO UNIVERSITA'
		Università u = new Università();
		Segreteria s = new Segreteria();
		
		//REGISTRO STUDENTE   OK!!!
		Studente s1 = s.registraStudente(u, "Adriano", "Celentano","");
		System.out.println(s1.toStringStudente());
		
		//REGISTRO DOCENTE    OK!!!
		Docente d1 = s.registraDocente(u, "Valeria", "Marini","123");
		System.out.println(d1.toStringDocente());
		
		//REGISTRO CORSO	  OK!!!
		Corso c1 = s.registraCorso(u, "Letteratura", 150);
		System.out.println(c1.toStringCorso());
		
		//AGGIUNGO STUDENTE A CORSO   OK!!!
		System.out.println(s.aggiungiStudenteACorso(u, s1, c1));
		
		//AGGIUNGO DOCENTE A CORSO    OK!!!
		System.out.println(s.aggiungiDocenteACorso(u, d1, c1));
		
		
	}	
	
	

}