package Universit‡;

import java.util.ArrayList;
import java.util.List;

import Biblioteca.Biblioteca;
import Biblioteca.Gestione;

public class Universit‡ implements validit‡Dati{
	
	// ATTRIBUTI
	private String nomeUni;
	
	private List<Studente> listaStudenti = new ArrayList<Studente>();
	private List<Docente> listaDocenti = new ArrayList<Docente>();
	private List<Corso> listaCorsi = new ArrayList<Corso>();
	
	private Biblioteca b = new Biblioteca();
	private Gestione g = new Gestione();
	
	// COSTRUTTORE VUOTO
	public Universit‡() {
	}
	
	// COSTRUTTORE CON ATTRIBUTO
	public Universit‡(String nomeUni) {
		this.nomeUni = nomeUni;
	}
	
	// METODI GET E SET
	public String getNomeUni() {
		return nomeUni;
	}

	public void setNomeUni(String nomeUni) {
		this.nomeUni = nomeUni;
	}

	public List<Studente> getListaStudenti() {
		return listaStudenti;
	}

	public void setListaStudenti(List<Studente> listaStudenti) {
		this.listaStudenti = listaStudenti;
	}
	
	public List<Docente> getListaDocenti() {
		return listaDocenti;
	}

	public void setListaDocenti(List<Docente> listaDocenti) {
		this.listaDocenti = listaDocenti;
	}

	public List<Corso> getListaCorsi() {
		return listaCorsi;
	}

	public void setListaCorsi(List<Corso> listaCorsi) {
		this.listaCorsi = listaCorsi;
	}
	
	public Biblioteca getB() {
		return b;
	}

	public void setB(Biblioteca b) {
		this.b = b;
	}

	public Gestione getG() {
		return g;
	}

	public void setG(Gestione g) {
		this.g = g;
	}

	// DEFINIZIONE METODO VALIDITA' DATI
	public boolean isValid(){
		boolean res = false;
		if((nomeUni.isEmpty()) && (nomeUni != null)){
			res = true;
		}
		return res;
	}	

}
