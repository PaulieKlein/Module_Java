package com.bankonet.model;

public final class CompteCourant extends Compte {
	
	//Attributs

	private double decouvertAutorise;
	
	
	//Constructeur
	public CompteCourant(String identifiant, String libelle, double solde, double decouvertAutorise){
		
		super(identifiant,libelle,solde);
		this.decouvertAutorise = decouvertAutorise;
	
	}

	
	//Accesseurs
	
	
	public double getDecouvertAutorise(){
		return this.decouvertAutorise;
	}
	
	public void setDecouvertAutorise(double decouvertAutorise ){
		this.decouvertAutorise = decouvertAutorise;
	}
	
public boolean debitAutorise(float montant){
		if(montant<=(super.getSolde()+this.getDecouvertAutorise())){
			//super.debiter(montant);
			return true;
		}
		System.err.println("\n Débit non autrisé pour le compte " + getLibelle());
		return false;
	}
	
	
	
	public boolean creditAutorise(float montant){
		//super.crediter(montant);
		return true;
	}
	
	public String toString(){
		return "\n Le compte courant : \n "+ super.toString() + "\n le découvert autorisé est de : " + getDecouvertAutorise(); 
	}
	
}
