package com.bankonet.model;

public class CompteEpargne {
	
	private String Numero;
	private String Intitule;
	private double Solde;
	private double tauxInteret;
	
	public CompteEpargne(String Numero,String Intitule,double Solde,double tauxInteret){
		this.Numero = Numero;
		this.Intitule = Intitule;
		this.Solde = Solde;
		this.tauxInteret = tauxInteret;
	}
	
	public String getIntitule() {
		return this.Intitule;
	}

	public void setIntitule(String intitule) {
		this.Intitule = intitule;
	}

	public double getSolde() {
		return this.Solde;
	}

	public void setSolde(double solde) {
		this.Solde = solde;
	}

	public double getTauxInteret() {
		return this.tauxInteret;
	}

	public void setTauxInteret(double tauxInteret) {
		this.tauxInteret = tauxInteret;
	}

	public String getNumero() {
		return this.Numero;
	}

	public void setNumero(String numero) {
		this.Numero = numero;
	}
	
	public String toString(){
		return "Numero : "+ this.getNumero() + "-\n" +
			   "Intitule : "+ this.getIntitule() + "-\n" +
			   "Solde : "+ this.getSolde(); 
	}

}
