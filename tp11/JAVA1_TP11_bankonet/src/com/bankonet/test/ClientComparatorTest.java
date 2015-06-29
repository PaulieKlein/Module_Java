package com.bankonet.test;

import java.util.ArrayList;
import java.util.List;

import com.bankonet.model.Client;
import com.bankonet.model.CompteCourant;
import com.bankonet.model.CompteEpargne;

public class ClientComparatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<CompteCourant> listCompteCourant1 = new ArrayList<>();
		List<CompteEpargne> listCompteEpargne1 = new ArrayList<>();
		List<CompteCourant> listCompteCourant2 = new ArrayList<>();
		List<CompteEpargne> listCompteEpargne2 = new ArrayList<>();
		List<CompteCourant> listCompteCourant3 = new ArrayList<>();
	
		listCompteCourant1.add(new CompteCourant("1", "compte courant 1", 0, 1000));
		listCompteEpargne1.add(new CompteEpargne("1", "compte epargne 1", 10, 2.54F, 20000));
		
		listCompteCourant2.add(new CompteCourant("2", "compte courant 2", 6000, 200));
		listCompteEpargne2.add(new CompteEpargne("2", "compte epargne 2", 10500, 1.67F, 30000));
		
		listCompteCourant3.add(new CompteCourant("3", "compte courant 3", -200, 300));
	
		// creation des clients
		List<Client> listClient =  new ArrayList<>();
		listClient.add(new Client("1","GUIBERT", "Fabien", listCompteCourant1, listCompteEpargne1));
		listClient.add(new Client("2","TOTO", "Titi", listCompteCourant2, listCompteEpargne2));
		listClient.add(new Client("3","DURAND", "Jacques", listCompteCourant3,new ArrayList<>()));
		
		System.out.println();
	}

}
