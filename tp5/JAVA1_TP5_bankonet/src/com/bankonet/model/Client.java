package com.bankonet.model;

public class Client {
	
	private String identifiant;
	private String nom;
	private String prenom;
	CompteCourant compteCourant;
	CompteEpargne compteEpargne;
	
	public Client(String identifiant,String nom,String prenom,CompteCourant compteCourant,CompteEpargne compteEpargne){
		this.identifiant = identifiant;
		this.nom = nom;
		this.prenom = prenom;
		this.compteCourant = null;
		if (compteCourant!=null){
			this.compteCourant = compteCourant; 
			}
		this.compteEpargne = null;
		if (compteEpargne!=null){
			this.compteEpargne = compteEpargne; 
			}
	}
	
	public String getIdentifiant() {
		return this.identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public CompteCourant getCompteCourant() {
		return this.compteCourant;
	}

	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}

	public CompteEpargne getCompteEpargne() {
		return this.compteEpargne;
	}

	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}
	public double calculerAvoirGlobal(){
		
		double montant;
		
		if (compteCourant != null && compteEpargne != null){
		 montant = compteCourant.getSolde() + compteEpargne.getSolde();
		return montant;}
		
		if (compteCourant == null && compteEpargne != null){
			 montant =  compteEpargne.getSolde();
			return montant;}
		
		if (compteCourant != null && compteEpargne == null){
			 montant =  compteCourant.getSolde();
			return montant;}
		
		else return montant = 0;
	}
	
	public String toString(){
		return "Nom : "+ this.getNom() + "-\n" +
				   "Prénom : "+ this.getPrenom();
	}
}
