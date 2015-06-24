package com.bankonet.model;

public class TestCompteCourant {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompteCourant compteCourant1 = new CompteCourant(1,"courant1",100F,100F);//instanciation de classe
		CompteCourant compteCourant2 = new CompteCourant(2,"courant2",200F,100F);
		CompteCourant compteCourant3 = new CompteCourant(3,"courant3",300F,100F);
		
		System.out.println("le solde du compte n° "+compteCourant1.getIdentifiant() +" est de " +compteCourant1.getSolde());
		System.out.println("le solde du compte n° "+compteCourant2.getIdentifiant() +" est de " +compteCourant2.getSolde());
		System.out.println("le solde du compte n° "+compteCourant3.getIdentifiant() +" est de " +compteCourant3.getSolde());
		
		System.out.println("le nombre de comptes courants créés est de " + CompteCourant.getNbComptesCourants() );//nbComptesCourants incrémenté
		
	}

}
