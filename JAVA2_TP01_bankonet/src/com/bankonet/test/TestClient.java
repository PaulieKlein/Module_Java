package com.bankonet.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.bankonet.ClientComparator;
import com.bankonet.model.BankonetException;
import com.bankonet.model.Client;
import com.bankonet.model.CompteCourant;
import com.bankonet.model.CompteEpargne;
import com.bankonet.model.Virement;


public class TestClient {

	 public static void main(String[] args) {
		 
		
		// Utilisation d'une collection : création de la liste des comptes courants/epargne
		List<CompteCourant> listCompteCourant1 = new ArrayList<>();
		List<CompteEpargne> listCompteEpargne1 = new ArrayList<>();
		List<CompteCourant> listCompteCourant2 = new ArrayList<>();
		List<CompteEpargne> listCompteEpargne2 = new ArrayList<>();
		List<CompteCourant> listCompteCourant3 = new ArrayList<>();
	
		listCompteCourant1.add(new CompteCourant(1, "compte courant 1", 0, 1000));
		listCompteEpargne1.add(new CompteEpargne(1, "compte epargne 1", 10, 2.54F, 20000));
		
		listCompteCourant2.add(new CompteCourant(2, "compte courant 2", 6000, 200));
		listCompteEpargne2.add(new CompteEpargne(2, "compte epargne 2", 10500, 1.67F, 30000));
		
		listCompteCourant3.add(new CompteCourant(3, "compte courant 3", -200, 300));
	
		// creation des clients
		List<Client> listClient =  new ArrayList<>();
		listClient.add(new Client(1,"GUIBERT", "Fabien", listCompteCourant1, listCompteEpargne1));
		listClient.add(new Client(2,"TOTO", "Titi", listCompteCourant2, listCompteEpargne2));
		listClient.add(new Client(3,"DURAND", "Jacques", listCompteCourant3,new ArrayList<>()));
		
		 for(Client myClient : listClient) {
			 	System.out.println();
			    System.out.println(myClient.toString());
			    System.out.println("Avoir global : "+myClient.calculerAvoirGLobal()+" €");
			    System.out.println("Liste de ses comptes :");
			    for(Object myCompte : myClient.getComptes()) {
			    	System.out.println(myCompte.toString());
			    }
		 }
	
		 System.out.println("\n\nTentative de virement de 700 € :");
		 Virement vir = new Virement(
				 			new CompteCourant(4, "compte courant 4", 600, 1000),
				 			new CompteCourant(5, "compte courant 5", 0, 1000),
				 			700);
		 
		 try {
			 
			vir.effectuerVirement();
			
		} catch (BankonetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		 
		 System.out.println("\n\n");
		 System.out.println("--------- TRI TABLEAU DE CLIENTS ---------------");

        List<Client> clients = new ArrayList<Client>();
        
        // Création des clients exemples
        clients.add(new Client(new Integer(12), "Elvis", "Goodyear"));
        clients.add(new Client(new Integer(23), "Stanley", "Clark"));
        clients.add(new Client(new Integer(7), "Jane", "Graff"));
        clients.add(new Client(new Integer(69), "Nancy", "Goodyear"));
        clients.add(new Client(new Integer(44), "Jammy", "Goodwill"));
        clients.add(new Client(new Integer(9266845), "Jammy", "Goodwill"));
        
        // Affichage de la liste des clients
        Iterator it = null;
        Client unClientBean = null;
        System.out.println("Organisation des clients avant le tri :");
        for (it = clients.iterator(); it.hasNext();) {
            unClientBean = (Client) it.next();
            System.out.println(unClientBean);
        }
        
        System.out.println("\nTri par l'identifiant (via le compareTo de l'objet) :");
        Collections.sort(clients);
        for (it = clients.iterator(); it.hasNext();) {
            unClientBean = (Client) it.next();
            System.out.println(unClientBean);
        }
        
        System.out.println("\nTri par le prénom (via le ClientBeanComparator) :");
        Collections.sort(clients, new ClientComparator());
        for (it = clients.iterator(); it.hasNext();) {
            unClientBean = (Client) it.next();
            System.out.println(unClientBean);
        }
    
}
		
			
	 }
	 
	 
	
