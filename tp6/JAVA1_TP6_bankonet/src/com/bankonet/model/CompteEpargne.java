package com.bankonet.model;

public class CompteEpargne extends Compte {
	
	private double tauxInteret;
	
	public CompteEpargne(String identifiant,String libelle,double solde,double tauxInteret){
		super(identifiant,libelle,solde);
		this.tauxInteret = tauxInteret;
	}
	


	public double getTauxInteret() {
		return this.tauxInteret;
	}

	public void setTauxInteret(double tauxInteret) {
		this.tauxInteret = tauxInteret;
	}

	public String toString(){
		return "\n Le compte �pargne : \n "+super.toString() + "\n le taux d'int�r�t est de : " + getTauxInteret(); 
	}

	public boolean debitAutorise(float montant){
		if(montant<=(super.getSolde())){
			super.debiter(montant);
			return true;
		}
		System.err.println("d�bit non autoris�");
		return false;
	}
	
	
	public boolean creditAutorise(float montant){
		return true;
	}
}
