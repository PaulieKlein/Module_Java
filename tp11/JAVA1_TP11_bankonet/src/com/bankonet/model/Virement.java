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

    /**
     * Accesseur à la propriete <code>compteDestination</code>.
     * 
     * @return tp.banque.Comptes
     */
    public Compte getCompteDestination() {
        return compteDestination;
    }

    /**
     * Accesseur de la propriete <code>compteSource</code>.
     * 
     * @return tp.banque.Comptes
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