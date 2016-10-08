package Università;

import Biblioteca.Utente;


public class Docente extends Utente {
	
	// COSTRUTTORE VUOTO
	public Docente() {
	}
	
	// COSTRUTTORE SPECIFICO DI DOCENTE
	public Docente(String nome, String cognome, String codiceFiscale) {
		super(nome,cognome,codiceFiscale);
	}
	
	// STRINGA DOCENTE
	public String toStringDocente(){
		String str ="";
		str += cf + "  " + nome + "  " + cognome + "\n";
		return str;
			
	}
		
	
	
	
	

}
