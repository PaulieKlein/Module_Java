package com.bankonet.model;

public abstract class Compte {
	
	private String identifiant;
	private String libelle;
	private double solde;
	

public Compte(String identifiant,String libelle,double solde){
	this.identifiant = identifiant;
	this.libelle = libelle;
	if(solde<0){
		System.out.println("un compte "+ getLibelle() +" ne peut pas être avec un solde négatif, le solde est à 0");
		this.solde = 0F;}
	else {this.solde = solde;}
	
}

public String getIdentifiant(){
	return this.identifiant;
}

public void setIdentifiant(String identifiant){
	this.identifiant=identifiant;
}

public String getLibelle(){
	return this.libelle;
}

public void setLibelle(String libelle){
	this.identifiant=libelle;
}


public double getSolde(){
	return this.solde;
}

public void setSolde(double solde){
	this.solde=solde;
}
	
public String toString(){
	return "ID : "+ this.getIdentifiant() + "-\n" +
			   "libelle : "+ this.getLibelle() + "-\n" +
			   "Solde : "+ this.getSolde(); 
}


public void crediter(float montant) {
	this.setSolde( this.getSolde() + montant);
}

public void debiter(float montant) {
	this.setSolde( this.getSolde() - montant);
}


}
