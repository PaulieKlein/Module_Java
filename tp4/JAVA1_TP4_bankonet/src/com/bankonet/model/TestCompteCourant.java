package com.bankonet.model;

public class TestCompteCourant {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int solde = 0;
		switch (solde) { 
		case 0: 
		System.out.println("solde nul"); 
		break;
		case 10000:
		System.out.println("solde créditeur"); 
		break;
		default:
		System.out.println("ras");
		break;
		 }

		
		CompteCourant compteCourant1 = new CompteCourant(1,"courant1",-100F,100F);//instanciation de classe
		CompteCourant compteCourant2 = new CompteCourant(2,"courant2",200F,200F);
		CompteCourant compteCourant3 = new CompteCourant(3,"courant3",300F,2000F);
		
		CompteCourant[] compteCourantTab = {compteCourant1,compteCourant2,compteCourant3};//instanciation de tableau d'objets
		
		for(int i = 0;i<compteCourantTab.length;i++) {
			System.out.println("le solde du compte n° "+compteCourantTab[i].getIdentifiant() +" est de " +compteCourantTab[i].getSolde());
		}
		
		int i = 0;
		while(i<compteCourantTab.length){
			System.out.println("le solde du compte n° "+compteCourantTab[i].getIdentifiant() +" est de " +compteCourantTab[i].getSolde());
			i++;
		}
			}

}
