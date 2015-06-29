package com.bankonet.test;

import java.util.ArrayList;
import java.util.Collection;

import com.bankonet.model.BankonetException;
import com.bankonet.model.CompteCourant;


public class TestCompteCourant {

	 public static void main(String[] args) {
		 
		
		 // création d'un tableau des comptes courant
		 CompteCourant[] tabCompteCourant = new CompteCourant[3];
		 tabCompteCourant[0] = new CompteCourant(4, "compte courant 1", 0, 1000);
		 tabCompteCourant[1] = new CompteCourant(5, "compte courant 1", 6000, 200);
		 tabCompteCourant[2] = new CompteCourant(6, "compte courant 1", -200, 300);
		 
		 // Parcours du tableau et affichage
		 System.out.println("------------------PARCOURS EN TABEAU--------------------------");
		 System.out.println("Nombre de comptes courants :" + CompteCourant.nombreComptesCourants);
		 System.out.println("Liste des comptes courants :");
		 
		 int i = 0;
		 while (i < 3) {
			 System.out.println(tabCompteCourant[i].toString());
			 i++;
		 }
		 
		 
		 
		 // Utilisation d'une collection : création de la liste des comptes courants
		 Collection<CompteCourant> listCompteCourant = new ArrayList<>();
		 
		 
		 // données mocktest
		 listCompteCourant.add(
				 new CompteCourant(1, "compte courant 1", 0, 1000));
		 listCompteCourant.add(
				 new CompteCourant(2, "compte courant 2", 6000, 200));
		 listCompteCourant.add(
				 new CompteCourant(3, "compte courant 3", -200, 300));
		 
		 
	
		 // affichage
		 System.out.println("\n------------------PARCOURS EN LISTE--------------------------");
		 System.out.println("Nombre de comptes courants :" + CompteCourant.nombreComptesCourants);
		 System.out.println("Liste des comptes courants :");
		 
		 for(CompteCourant myCC : listCompteCourant) {
			 	System.out.println();
			    System.out.println(myCC.toString());   	
			    
			    System.out.print("\t\t Essai retrait de 1000€.... ");
			    try {
			    	
					myCC.debitAutorise(1000);
					System.out.println("OK !");
					
				} catch (BankonetException e) {
					e.getCause();
					e.printStackTrace();
				}
			    
			    System.out.print("\t\t Essai dépot de 500€.... ");
			    try {
			    	
					myCC.creditAutorise(500);
					System.out.println("OK !");
					
				} catch (BankonetException e) {
					e.printStackTrace();
				}
			    
			    
		 }
		 
		 
		
			
	 }
	 
	 
	 
}
