package com.bankonet.model;



public abstract class Compte implements CompteStat{
	private String libelle;
	private int identifiant;
	protected float solde;

	Compte() { }
	Compte(int id, String libelle, float solde) {
		this.identifiant = id;
		this.libelle = libelle;
		this.solde = solde;
	}
	
	public String toString() {
	        return  " ID  : "+this.getIdentifiant() +" - "+
		    		" Lib : "+this.getLibelle()+" - "+
		    		" Solde : "+this.getSolde()+"€";
	}

	public void crediter(float montant) {
		this.setSolde( this.getSolde() + montant);
	}
	
	public void effectuerVirement(Compte compte,float montant) throws DebitException{
		if (compte.getSolde() >= montant){
			compte.setSolde(compte.getSolde()- montant);
			this.setSolde(this.getSolde() + montant);	
		}
		else {
            throw new DebitException("Montant trop élevé : le solde du compte courant "+ compte.getIdentifiant() + " ne peut descendre en dessous du decouvert autorise" );
        }
		}
	
	public void debiter(float montant) throws DebitException {
		if (this.getSolde() >= montant) {
        	//debiter(montant);
			this.setSolde( this.getSolde() - montant);
        } else {
            throw new DebitException("Montant trop élevé : le solde du compte courant "+ this.getIdentifiant() + " ne peut descendre en dessous du decouvert autorise" );
        }
		
	
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

	private void setSolde(float newSolde) {
		this.solde = newSolde;
	}
}
