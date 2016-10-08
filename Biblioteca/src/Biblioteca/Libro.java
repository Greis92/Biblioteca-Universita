package Biblioteca;

import Universit‡.validit‡Dati;


public class Libro implements validit‡Dati {
	
	// ATTRIBUTI
	private String titolo;
	private String autore;
	
	private String serialNum;
	
	private int copieTotali; // COPIE TOTALI PER OGNI LIBRO
	
	private int copieDisponibili; // COPIE DISPONIBILI EFFETTIVE PER OGNI LIBRO
	
	// COSTRUTTORE VUOTO
	public Libro() {
	}
	
	// COSTRUTTORE CON ATTRIBUTI
	public Libro(String titolo, String autore, String serialNum) {
		this.titolo = titolo;
		this.autore = autore;
		this.serialNum = serialNum;
		this.copieTotali = 0;
		this.copieDisponibili = 0;
	}

	// METODI GET E SET
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}
	
	public int getCopieTotali() {
		return copieTotali;
	}

	public void setCopieTotali(int copieTotali) {
		this.copieTotali = copieTotali;
	}

	public int getCopieDisponibili() {
		return copieDisponibili;
	}

	public void setCopieDisponibili(int copieDisponibili) {
		this.copieDisponibili = copieDisponibili;
	}
	
	// STRINGA LIBRO
	public String toStringLibro(){
		String str ="";
		
		str += serialNum + "  " + titolo + "  " + autore + "\n";
		
		return str;
	}
	
	
	// DEFINIZIONE METODO VALIDITA' DATI
	public boolean isValid(){
		
		boolean res = false;
		
		if(
			!(titolo.isEmpty()) && (titolo != null) && 
			!(autore.isEmpty()) && (autore != null) &&
			!(serialNum.isEmpty()) && (serialNum != null))
		{
			res = true;
		}
		return res;
	}

	
	
	
	
	
	

}
