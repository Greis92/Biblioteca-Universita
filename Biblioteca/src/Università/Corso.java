package Universit‡;

import java.util.ArrayList;
import java.util.List;

public class Corso implements validit‡Dati{
	
	// ATTRIBUTI
	private String nomeCorso;
	private int ore;
	
	private List<Studente> studentiDelCorso = new ArrayList<Studente>();
	private List<Docente> docentiDelCorso = new ArrayList<Docente>();
	
	
	// COSTRUTTORE VUOTO
	public Corso() {
	}
	
	// COSTRUTTORE CON ATTRIBUTI 
	public Corso(String nomeCorso, int ore) {
		this.nomeCorso = nomeCorso;
		this.ore = ore;
	}
	
	// METODI GET E SET
	public String getNomeCorso() {
		return nomeCorso;
	}

	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}
	
	public int getOre() {
		return ore;
	}

	public void setOre(int ore) {
		this.ore = ore;
	}
	
	public List<Studente> getStudentiDelCorso() {
		return studentiDelCorso;
	}

	public void setStudentiDelCorso(List<Studente> studentiDelCorso) {
		this.studentiDelCorso = studentiDelCorso;
	}
	
	public List<Docente> getDocentiDelCorso() {
		return docentiDelCorso;
	}

	public void setDocentiDelCorso(List<Docente> docentiDelCorso) {
		this.docentiDelCorso = docentiDelCorso;
	}
	
	// STRINGA CORSO
	public String toStringCorso(){
		String str ="";
		str += nomeCorso + "  " + ore + "\n";
		return str;
				
		}

	// DEFINIZIONE METODO VALIDITA' DATI
	public boolean isValid(){
		boolean res = false;
		if((nomeCorso.isEmpty()) && (nomeCorso != null)){
			res = true;
		}
		return res;
	}
		
}
