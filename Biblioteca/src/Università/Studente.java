package Università;

import Biblioteca.Utente;

public class Studente extends Utente {
	
	// ATTRIBUTI SPECIFICI DI STUDENTE
	private String matricola;
	private double media;
	
	// COSTRUTTORE VUOTO
	public Studente(){
	}
	
	// COSTRUTTORE SPECIFICO DI STUDENTE
	public Studente(String nome, String cognome) {
		super(nome,cognome);
	}
	
	// METODI GET E SET SPECIFICI 
	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}
	
	// STRINGA STUDENTE
	public String toStringStudente(){
		String str ="";
		str += matricola + "  " + nome + "  " + cognome + "\n";
		return str;
		
	}
	
	
	
	

}
