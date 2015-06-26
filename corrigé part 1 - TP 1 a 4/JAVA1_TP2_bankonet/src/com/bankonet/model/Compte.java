package com.bankonet.model;


/**
 * @author fguibert
 */
public abstract class Compte {
	private String libelle;
	private int identifiant;
	protected float solde;

	/**
	 * Constructeur standard.
	 */
	Compte(int id, String libelle, float solde) {

		this.identifiant = id;
		this.libelle = libelle;
		this.solde = solde;

	}
	public abstract boolean creditAutorise(float montant) throws BankonetException;


	public abstract boolean debitAutorise(float montant) throws BankonetException;

	public String getLibelle() {
		return libelle;
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float newSolde) {
		this.solde = newSolde;
	}
}
