package Università;

public class Segreteria {
	
	/*METODO CHE CONTROLLA SE LO STUDENTE ESISTE 
	 * ALTRIMENTI CREA LA NUOVA MATRICOLA E LO REGISTRA
	 * RITORNA L'OGGETTO REGISTRATO
	 */
	public Studente registraStudente(Università u, String nome, String cognome, String matricola){
		Studente studente = ricercaStudente(u,matricola);
		
		if(studente == null){
			
			studente = new Studente(nome,cognome);
			studente.setMatricola(nome.substring(1, 3) + cognome.substring(1, 3) + u.getListaStudenti().size()+1);
			u.getListaStudenti().add(studente);
			
		}
		
		return studente;	
	}
	
	// METODO HELPER PER REGISTRASTUDENTE
	private Studente ricercaStudente(Università u, String matricola){
		Studente sTemp = null;
		
		for(Studente s : u.getListaStudenti()){
			
			if(s.getMatricola().equals(matricola)){
				
				sTemp = s;
				break;
			
			}
		
		}
		
		return sTemp;
	}
	
	/*METODO CHE CONTROLLA SE IL DOCENTE ESISTE,
	 * ALTRIMENTI PROCEDE CON LA REGISTRAZIONE E RITORNA L'OGGETTO DOCENTE
	 */
	public Docente registraDocente(Università u, String nome, String cognome, String codiceFiscale){
		Docente docente = ricercaDocente(u,codiceFiscale);
		
		if(docente == null){
			
			docente = new Docente(nome,cognome,codiceFiscale);
			u.getListaDocenti().add(docente);
		
		}
		
		return docente;	
	}
	
	// METODO HELPER PER IL METODO REGISTRADOCENTE
	private Docente ricercaDocente(Università u, String codiceFiscale){
		Docente dTemp = null;
		
		for(Docente d : u.getListaDocenti()){
			
			if(d.getCf().equals(codiceFiscale)){
				
				dTemp = d;
				break;
			
			}
		
		}
		
		return dTemp;
	}
	
	/*METODO CHE CONTROLLA SE IL CORSO ESISTE ALTRIMENTI VIENE REGISTRATO
	 * RITORNA L'OGGETTO CORSO
	 */
	public Corso registraCorso(Università u, String nome, int ore){
		Corso corso = ricercaCorso(u,nome);
		
		if(corso == null){
			
			corso = new Corso(nome,ore);
			u.getListaCorsi().add(corso);
		
		}
		
		return corso;	
	}
	
	//METODO HELPER PER REGISTRACORSO
	private Corso ricercaCorso(Università u, String nome){
		Corso cTemp = null;
		
		for(Corso c : u.getListaCorsi()){
			
			if(c.getNomeCorso().equals(nome)){
				
				cTemp = c;
				break;
			
			}
		
		}
		
		return cTemp;
	}
	
	/*METODO CHE CONTROLLA SE LO STUDENTE E' GIA REGISTRATO AL CORSO
	 * ALTRIMENTI LO AGGIUNGE AL CORSO, RITORNA UN BOOLEAN
	 */
	public boolean aggiungiStudenteACorso(Università u, Studente studente, Corso corso){
		boolean studenteAggiunto = false;
		
		Studente temp = ricercaStudente(u,studente.getMatricola());
		Studente stud = null;
		
		if(temp != null){
			
			stud = ricercaStudenteInCorso(temp,corso);
			
			if(stud == null){
				stud = temp;
				corso.getStudentiDelCorso().add(stud);
				studenteAggiunto = true;
			}
			
		}
		
		return studenteAggiunto;
		
	}
	
	//METODO HELPER PER AGGIUNGISTUDENTEACORSO
	private Studente ricercaStudenteInCorso(Studente studente, Corso corso){
		Studente sTemp = null;
		
		for(Studente s : corso.getStudentiDelCorso()){
			
			if(s.getMatricola().equals(studente.getMatricola())){
				
				sTemp = s;
				break;
			
			}
		
		}
		
		return sTemp;
	}
	
	/*METODO CHE CONTROLLA SE IL DOCENTE ESISTE
	 * SE ESISTE LO AGGIUNGE AL CORSO E RITORNA UN BOOLEAN.
	 * E' PREVISTO CHE PIU' DOCENTI POSSO INSEGNARE NELLO STESSO CORSO
	 */
	public boolean aggiungiDocenteACorso(Università u, Docente docente, Corso corso){
		boolean docenteAggiunto = false;
		
		Docente temp = ricercaDocente(u, docente.getCf());
		
		if(temp != null){
			
			corso.getDocentiDelCorso().add(temp);
			docenteAggiunto = true;
		
		}
		
		return docenteAggiunto;	
	}
	
	
	
	
}
