package com.bankonet.test;

import java.util.ArrayList;
import java.util.List;

import com.bankonet.CompteStat;
import com.bankonet.model.*;

public class DonneesTest {
	
	public static List<CompteStat> construitEchantillonComptes() {
			
		List<CompteStat> listComptes = new ArrayList<>();
				
		listComptes.add(new CompteCourant(1, "compte courant 1", 0, 1000));
		listComptes.add(new CompteCourant(2, "compte courant 2", 500, 200));
		listComptes.add(new CompteCourant(3, "compte courant 3", 20, 0));
		listComptes.add(new CompteEpargne(4, "compte épargne 4", 1, 2.54F, 20000F));
		listComptes.add(new CompteEpargne(5, "compte épargne 5", 10000, 13.42F, 20000F));
		

		return listComptes;
/*
-------- Déclaratations  alternatives :

-------- Type de retour : Liste de comptes  :

public static List<Compte> construitEchantillonComptes() {
---------	
		List<Compte> listComptes = new ArrayList<>();
		
		listComptes.add(new CompteCourant(1, "compte courant 1", 0, 1000));
		listComptes.add(new CompteCourant(2, "compte courant 2", 500, 200));
		listComptes.add(new CompteCourant(3, "compte courant 3", 20, 0));
		listComptes.add(new CompteEpargne(4, "compte épargne 4", 1, 2.54F, 20000F));
		listComptes.add(new CompteEpargne(5, "compte épargne 5", 1000000, 13.42F, 20000F));
		
		return listComptes;
		
*/
				
/*
	
-------- Type de retour : Tableau de Comptes  :
--------- 
public static Compte[] construitEchantillonComptes() {
		Compte[] tabComptes = new Compte[5];
		tabComptes[0] = new CompteCourant(1, "compte courant 1", 0, 1000);
		tabComptes[1] = new CompteCourant(2, "compte courant 2", 500, 200);
		tabComptes[2] = new CompteCourant(3, "compte courant 3", 20, 0);
		tabComptes[3] = new CompteEpargne(4, "compte épargne 4", 1, 2.54F,20000F);
		tabComptes[4] = new CompteEpargne(5, "compte épargne 5", 1000000,13.42F, 20000F);

		return tabComptes;
	
	
*/

	
}
	
	
}

