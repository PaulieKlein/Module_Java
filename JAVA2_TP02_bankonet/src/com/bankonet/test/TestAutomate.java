package com.bankonet.test;

import java.util.ArrayList;
import java.util.List;

import com.bankonet.CompteStat;

public class TestAutomate {

	 public static void main(String[] args) {
		 
		 List<CompteStat> listCompteStat = new ArrayList<>();
		 
		 listCompteStat = DonneesTest.construitEchantillonComptes();
		
		 // calcul moyenne du solde des comptes
		 float moyenne = 0;
		 for (CompteStat myC : listCompteStat)
			 moyenne += myC.getSolde(); 
		 moyenne = moyenne/5;
		 System.out.println("Moyenne des soldes de comptes :"+ moyenne +" €");   
	
	 }

				 
			
	 }
	 
	 
	 
