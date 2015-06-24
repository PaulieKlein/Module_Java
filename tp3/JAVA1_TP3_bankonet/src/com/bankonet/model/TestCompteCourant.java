package com.bankonet.model;

public class TestCompteCourant {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompteCourant compteCourant1 = new CompteCourant(1,"courant1",100F,100F);//instanciation de classe
		
		System.out.println("le solde du compte n� "+compteCourant1.getIdentifiant() +" est de " +compteCourant1.getSolde());

		
		System.out.println("le nombre de comptes courants cr��s est de " + CompteCourant.getNbComptesCourants() );//nbComptesCourants incr�ment� � chaque instanciation de classe
		
		System.out.println("la demande de cr�dit est " + compteCourant1.creditAutorise(100) );
		System.out.println("la demande de d�bit est " + compteCourant1.debitAutorise(50) );
		System.out.println("la demande de d�bit est " + compteCourant1.debitAutorise(1000) );
	}

}
