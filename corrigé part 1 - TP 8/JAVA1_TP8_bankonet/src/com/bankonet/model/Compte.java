package com.bankonet.model;

import com.bankonet.CompteStat;


/**
 * @author fguibert
 */
public abstract class Compte implements CompteStat {
	private String libelle;
	private int identifiant;
	protected float solde;

	
	Compte(int id, String libelle, float solde) {

		this.identifiant = id;
		this.libelle = libelle;
		this.solde = solde;

	}

	// TP 7 : méthode getter implémentée pour l'interface CompteStat
	public float getSolde() {
		return solde;
	}


	
	public abstract boolean creditAutorise(float montant) throws BankonetException;

	public abstract boolean debitAutorise(float montant) throws BankonetException;

	public String toString() {
		
	        return  " ID  : "+this.getIdentifiant() +" - "+
		    		" Lib : "+this.getLibelle()+" - "+
		    		" Solde : "+this.getSolde()+"€";
	    
	}
	
	public String getLibelle() {
		return libelle;
	}

	public int getIdentifiant() {
		return identifiant;
	}


	public void setSolde(float newSolde) {
		this.solde = newSolde;
	}
}
