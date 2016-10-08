package Biblioteca;

import Universit‡.validit‡Dati;

import java.util.HashMap;
import java.util.Map;

public class Utente implements validit‡Dati {
	
	// ATTRIBUTI
	protected String nome;
	protected String cognome;
	protected String cf;
	
	protected Map<String,Libro> libri = new HashMap<String,Libro>(3);/* LISTA LIBRI IN PRESTITO PER UTENTE
																	  * DEFINIZIONE MAPPA CON MASSIMO TRE ELEMENTI
																	  */
	
	// COSTRUTTORE VUOTO
	public Utente() {
	}
	
	// COSTRUTTORE CON ATTRIBUTI
	public Utente(String nome, String cognome, String cf) {
		this.nome = nome;
		this.cognome = cognome;
		this.cf = cf;
	}
	
	// COSTRUTTORE CON ATTRIBUTI
	public Utente(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}
	
	// METODI GET E SET
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public Map<String, Libro> getLibri() {
		return libri;
	}

	public void setLibri(Map<String, Libro> libri) {
		this.libri = libri;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}
	
	public int getNumeroLibri(){
		return this.libri.size();
	}
	
	public void aggiungiLibro(Libro l){
		this.libri.put(l.getSerialNum(),l);
	}

	// STRINGA UTENTE
	public String toStringUtente(){
		String str ="";
		
		str += cf + "  " + nome + "  " + cognome + "\n";
		
		return str;
	}
	
	// STRINGA MAPPA LIBRI UTENTE
	public String toStringMappaLibri(){
		String str = "";
		for(Map.Entry<String, Libro> entry: libri.entrySet()){
			str += entry.getValue().toStringLibro();
		}
		if(str == "")
			return str = "      Lista Vuota!";
		else
			return str;
	}
	
	// DEFINIZIONE METODO VALIDITA' DATI
	public boolean isValid(){
		
		boolean res = false;
		
		if(
			!(nome.isEmpty()) && (nome != null) && 
			!(cognome.isEmpty()) && (cognome != null) &&
			!(cf.isEmpty()) && (cf != null)
		){
			res = true;
		}
		
		return res;
	}
		

}