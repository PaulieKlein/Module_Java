package com.bankonet.model;

public class CompteCourant {
	
	//Attributs
	private int identifiant;
	private String libelle;
	private Float solde;
	private Float decouvertAutorise;
	
	
	//Constructeur
	public CompteCourant(int identifiant, String libelle, Float solde, Float decouvertAutorise){
		this.identifiant = identifiant;
		this.libelle = libelle;

		this.decouvertAutorise = decouvertAutorise;
		if(solde<0F){
			System.out.println("un compte ne peut pas être avec un solde négatif, le solde est à 0");
			this.solde = 0F;}
		else {this.solde = solde;}
		
	
	}

	
	//Accesseurs
	public int getIdentifiant(){
		return identifiant;
	}
	
	public void setIdentifiant(int identifiant){
		
		this.identifiant = identifiant;
	}
	
	public String getLibelle(){
		return this.libelle;
	}
	
	public void setLibelle(String libelle ){
		this.libelle = libelle;
	}
	
	public Float getSolde(){
		return this.solde;
	}
	
	public void setSolde(Float solde ){
		this.solde = solde;
	}
	
	public Float getDecouvertAutorise(){
		return this.decouvertAutorise;
	}
	
	public void setDecouvertAutorise(Float decouvertAutorise ){
		this.decouvertAutorise = decouvertAutorise;
	}
	
	public boolean debitAutorise(float montant){
		return (montant<=solde);
	}
	
	public boolean creditAutorise(float montant){
		return true;
	}
	
	public String toString(){
		return "ID : "+ this.getIdentifiant() + "-\n" +
			   "libelle : "+ this.getLibelle() + "-\n" +
			   "Solde : "+ this.getSolde(); 
	}
}
