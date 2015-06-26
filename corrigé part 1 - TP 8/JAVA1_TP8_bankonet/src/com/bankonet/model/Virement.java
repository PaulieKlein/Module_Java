package com.bankonet.model;

/**
 * Modelise un virement d'un compte vers un autre.
 * 
 * @author fguibert
 */
public class Virement {

	private Compte compteDestination;

	private Compte compteSource;

	private float montant;

	/**
	 * @param compteDestination
	 * @param compteSource
	 * @param montant
	 */
	public Virement(Compte compteSource, Compte compteDestination, float montant) {
		this.compteSource = compteSource;
		this.compteDestination = compteDestination;
		this.montant = montant;
	}

	// TP 8 - Effectuer virement
	public void effectuerVirement() throws BankonetException {

		System.out.println(" - Compte Source - ID  : "+this.getCompteSource().getIdentifiant() +" - Lib : "+this.getCompteSource().getLibelle()+" - Solde : "+this.getCompteSource().getSolde()+" €");
		System.out.println(" - Compte Dest   - ID  : "+this.getCompteDestination().getIdentifiant() +" - Lib : "+this.getCompteDestination().getLibelle()+" - Solde : "+this.getCompteDestination().getSolde()+" €");
		
		// vérification des autorisations
		if (this.getCompteSource().debitAutorise(this.montant)
		&& (this.getCompteDestination().creditAutorise(this.montant))) {

			float s1 = this.getCompteSource().getSolde();
			float s2 = this.getCompteDestination().getSolde();
			
			this.getCompteSource().setSolde(s1-this.montant);
			this.getCompteDestination().setSolde(s2+this.montant);
			System.out.println("Virement OK !");
			
		} else {
			throw new BankonetException("Virement non autorisé");
		}
		
	
		System.out.println(" - Compte Source - ID  : "+this.getCompteSource().getIdentifiant() +" - Lib : "+this.getCompteSource().getLibelle()+" - Solde : "+this.getCompteSource().getSolde()+" €");
		System.out.println(" - Compte Dest   - ID  : "+this.getCompteDestination().getIdentifiant() +" - Lib : "+this.getCompteDestination().getLibelle()+" - Solde : "+this.getCompteDestination().getSolde()+" €");
			
	}

	/**
	 * Accesseur à la propriete <code>compteDestination</code>.
	 * 
	 */
	public Compte getCompteDestination() {
		return compteDestination;
	}

	/**
	 * Accesseur de la propriete <code>compteSource</code>.
	 * 
	 */
	public Compte getCompteSource() {
		return compteSource;
	}

	/**
	 * Accesseur de la propriete <code>montant</code>.
	 * 
	 * @return float
	 */
	public float getMontant() {
		return montant;
	}
}