package Biblioteca;

import java.util.Date;

public class Prestito {
	
	// ATTRIBUTI
	private Libro l;
	
	private Utente u;
	
	private Date dataPrestito; // UGUALE A SCRIVERE "java.util.Date dataPrestito"
	
	private Date dataRestituzione; // " "
	
	// COSTRUTTORE VUOTO
	public Prestito() {
	}
	
	// COSTRUTTORE CON ATTRIBUTI
	public Prestito(Libro l, Utente u, Date dataPrestito, Date dataRestituzione) {
		this.l = l;
		this.u = u;
		this.dataPrestito = dataPrestito;
		this.dataRestituzione = dataRestituzione;
	}
	
	// METODI GET E SET
	public Libro getL() {
		return l;
	}

	public void setL(Libro l) {
		this.l = l;
	}

	public Utente getU() {
		return u;
	}

	public void setU(Utente u) {
		this.u = u;
	}

	public Date getDataPrestito() {
		return dataPrestito;
	}

	public void setDataPrestito(Date dataPrestito) {
		this.dataPrestito = dataPrestito;
	}

	public Date getDataRestituzione() {
		return dataRestituzione;
	}

	public void setDataScadenza(Date dataRestituzione) {
		this.dataRestituzione = dataRestituzione;
	}
	
	
	// STRINGA PRESTITO
	public String toStringPrestito(){
		String datiPrestito = "";
	
		datiPrestito = "Libro: " + l.toStringLibro() + "\n" +
			"Utente: " + u.toStringUtente() + "\n" +
			"Data Prestito: " + dataPrestito + "\n" + 
			"Data Restituzione: " + dataRestituzione + "\n\n";
	
		return datiPrestito;
	}
	
}
