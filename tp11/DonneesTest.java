package com.bankonet.test;

import java.util.ArrayList;
import java.util.List;

import com.bankonet.CompteStat;
import com.bankonet.model.*;

public class DonneesTest {
	
	
	public static List<Client> construitEchantillonClients() {
		List<Client> clients=new ArrayList<Client>();
        Client client;

        client=new Client();
        client.setNom ("Hugo");
        client.setPrenom("Victor");

        client.setCompteCourantList(getCompteCourantListData(client));
        client.setCompteEpargneList(getCompteEpargneListData(client));
        clients.add(client);

        client=new Client();
        client.setNom ("Lincoln");
        client.setPrenom("Abraham");
        client.setCompteCourantList(getCompteCourantListData(client));
        client.setCompteEpargneList(getCompteEpargneListData(client));
        clients.add(client);

        client=new Client();
        client.setNom ("Skoblar");
        client.setPrenom("Josip");
        client.setCompteCourantList(getCompteCourantListData(client));
        client.setCompteEpargneList(getCompteEpargneListData(client));
        clients.add(client);

        return clients;
	}
	
	
	        

	  public static List<CompteEpargne> getCompteEpargneListData(Client client) {
	        List<CompteEpargne> compteEpargneList=new ArrayList<CompteEpargne>();
	        compteEpargneList.add(new CompteEpargne(
	        		new Integer(-1),
	        		"C.E.1 de"+client.getPrenom()+" "+client.getNom(),
	        		new Float(1000.0),
	        		new Float(5),
	        		new Float(10000.0f)));
	        compteEpargneList.add(new CompteEpargne(
	        		new Integer(-1),
	        		"C.E.2 de "+client.getPrenom()+" "+client.getNom(),
	        		new Float(500.0f),
	        		new Float(10), 
	        		new Float(10000.0f)));
	        compteEpargneList.add(new CompteEpargne(
	        		new Integer(-1),
	        		"C.E.3 de "+client.getPrenom()+" "+client.getNom(),
	        		new Float(5000.0f),
	        		new Float(8),
	        		new Float(100000.0f)));
	        return compteEpargneList;
	    }

	    public static List<CompteCourant> getCompteCourantListData(Client client) {
	        List<CompteCourant> compteCourantList=new ArrayList<CompteCourant>();
	        compteCourantList.add(new CompteCourant(
	        		new Integer(-1), 
	        		"C.C.1 de "+client.getPrenom()+" "+client.getNom(), 
	        		new Float(10.0f),
	        		new Float(200.0f)));
	        compteCourantList.add(new CompteCourant(
	        		new Integer(-1),
	        		"C.C.2 de "+client.getPrenom()+" "+client.getNom(), 
	        		new Float(200.0f),
	        		new Float(10000.0f)));
	        compteCourantList.add(new CompteCourant(
	        		new Integer(-1),
	        		"C.C.3 de "+client.getPrenom()+" "+client.getNom(),
	        		new Float(4000.0f),
	        		new Float(0.0f)));
	        return compteCourantList;
	    }
	
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

