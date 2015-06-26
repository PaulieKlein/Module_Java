package com.bankonet.model;

/**
 * @author fguibert
 */
public final class CompteCourant extends Compte {
    private float decouvertAutorise;
    public static int nombreComptesCourants = 0;

 
    public CompteCourant(int id, String libelle, float solde, float decouvertAutorise) {

        super(id, libelle, solde);

        this.decouvertAutorise = decouvertAutorise;
        nombreComptesCourants++;
    }

    /**
     * Le credit d'un compte courant est toujours autorise
     */
    public boolean creditAutorise(float montant) throws BankonetException {
        return true;
    }

    public boolean debitAutorise(float montant) throws BankonetException {
        if (this.getSolde() + this.getDecouvertAutorise() >= montant) {
            return true;
        } else {
            throw new BankonetException("Montant trop eleve : le solde du compte courant "+ this.getIdentifiant() + " ne peut descendre en dessous du decouvert autorise" );
        }
    }

    /**
     * Accesseur de la propriete <code>decouvertAutorise</code>.
     * 
     * @return float
     */
    public float getDecouvertAutorise() {
        return decouvertAutorise;
    }
    
    public String toString() {
        return   super.toString()+
	    		" - Découvert autorisé : "+this.getDecouvertAutorise()+" €";
    }
}