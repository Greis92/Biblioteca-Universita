package Biblioteca;

import java.util.HashMap;
import java.util.Map;


public class Biblioteca {
	
	// ATTRIBUTI
	private String nomeBiblioteca;
	
	private Map<String,Libro> mappaLibri = new HashMap<String,Libro>();// MAPPA LIBRI DELLA BIBLIOTECA
	
	private Map<String,Utente> mappaUtenti = new HashMap<String,Utente>(); // MAPPA UTENTI REGISTRATI
	
	private Map<String,Prestito> mappaPrestiti = new HashMap<String,Prestito>(); // MAPPA PRESTITI ESEGUITI
	
	// COSTRUTTORE VUOTO
	public Biblioteca(){
	}
	
	// COSTRUTTORE CON ATTRIBUTO NOME
	public Biblioteca(String nomeBiblioteca){
		this.nomeBiblioteca = nomeBiblioteca;
	}
	
	// METODI GET E SET
	public String getNome(){
		return nomeBiblioteca;
	}
	
	public void setNome(String nome){
		this.nomeBiblioteca = nome;
	}

	public Map<String, Libro> getMappaLibri() {
		return mappaLibri;
	}

	public void setMappaLibri(Map<String, Libro> mappaLibri) {
		this.mappaLibri = mappaLibri;
	}

	public Map<String, Utente> getMappaUtenti() {
		return mappaUtenti;
	}
	
	public Map<String, Prestito> getMappaPrestiti() {
		return mappaPrestiti;
	}

	public void setMappaPrestiti(Map<String, Prestito> mappaPrestiti) {
		this.mappaPrestiti = mappaPrestiti;
	}

	public void setMappaUtenti(Map<String, Utente> mappaUtenti) {
		this.mappaUtenti = mappaUtenti;
	}
	
	public void aggiungiLibro(Libro l){
		this.mappaLibri.put(l.getSerialNum(),l);
	}
	
	public void aggiungiUtente(Utente u){
		this.mappaUtenti.put(u.getCf(),u);
	}

	// STRINGA DELLA MAPPA LIBRI
	public String toStringLibri(){
		String str ="";
		for(Map.Entry<String, Libro> entry: mappaLibri.entrySet()){
			str += entry.getValue().toStringLibro();
		}
		return str;
	}
	
	// STRINGA DELLA MAPPA UTENTI
	public String toStringUtenti(){
		String str = "";
		for(Map.Entry<String, Utente> entry: mappaUtenti.entrySet()){
			str += entry.getValue().toStringUtente();
		}
		return str;
	}
	
	// STRINGA DELLA MAPPA PRESTITI
		public String toStringPrestiti(){
			String str = "";
			for(Map.Entry<String, Prestito> entry: mappaPrestiti.entrySet()){
				str += entry.getValue().toStringPrestito();
			}
			return str;
		}
	

}
