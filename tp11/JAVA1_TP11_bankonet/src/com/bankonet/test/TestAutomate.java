package com.bankonet.test;

import com.bankonet.model.CompteStat;

public class TestAutomate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float moyenne;
		float somme = 0;
	CompteStat[] comptes = DonneesTest.construitEchantillonComptes();
	for(int i=0;i<comptes.length;i++){
		somme += comptes[i].getSolde();
	}
	moyenne = somme/comptes.length;
	 System.out.println("la moyenne des soldes est de "+ moyenne + " euros") ;
	 
	}
	
}
