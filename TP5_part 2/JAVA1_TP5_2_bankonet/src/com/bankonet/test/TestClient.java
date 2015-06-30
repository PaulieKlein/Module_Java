package com.bankonet.test;

import java.util.*;
import java.util.function.*;
import java.io.*;

import com.bankonet.model.*;
//import com.bankonet.collection.Filtrage;

public class TestClient {

	/*//1ère solution
	public static void monFiltre (List<Client> mylist, Filtrage f){
		for(Client val : mylist) if (f.filtre(val.getNom())) System.out.println(val);
	}
	
	//2ème solution
	public static void monFiltre (List<Client> o, Predicate f){
		for(Client val : o) if (f.filtre(val.getNom())) System.out.println(val);
	}*/
	
	 public static void main(String[] args) throws DebitException {
		 
		
		// Utilisation d'une collection : création de la liste des comptes courants/epargne
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
		
		 for(Client myClient : listClient) {
			 	System.out.println();
			    System.out.println(myClient.toString());
			    System.out.println("Avoir global : "+myClient.calculerAvoirGLobal()+" €");
			    for(Object myCompte : myClient.getComptes()) {
			    	System.out.println(myCompte.toString());
			    }
			    
//			    for(Object myCE : myClient.getComptesEpargne()) {
//		    		System.out.println(myCE.toString2());
//			    }
			    
		 }
		 		CompteCourant compte1 =new CompteCourant("1", "compte courant 1", 0, 1000);
		 		CompteCourant compte2 =new CompteCourant("2", "compte courant 2", 20, 1000);
				compte1.effectuerVirement(compte2,5F);
				System.out.println("\nVirement de 5 : \nSolde du Compte 2 : " + compte2.getSolde() + "\nSolde du Compte 1 : " + compte1.getSolde());
		 
		 
				System.out.println("\nTri par le nom (via le ClientBeanComparator) :");

		        Collections.sort(listClient, new ClientComparator());
		        Iterator<Client> it  = null;
		        Client unClientBean = null;

		        for (it = listClient.iterator(); it.hasNext();) {
		            unClientBean = (Client) it.next();
		            System.out.println(unClientBean);

		        }
		        
		        System.out.println("\nTri par le nom (via le Lambda) :");
		        
		        Collections.sort(listClient, (o1,o2) -> 
		        									((Client) o1).getNom().compareTo(((Client) o2).getNom()) );
		        
		        
		       /* System.out.println("\nFiltrage sur le nom TOTO (via le Lambda) :");								
		        monFiltre(listClient,(e) -> e.equals("TOTO"));
		        
		        
		        System.out.println("\nTri d'un tableau avec les stream :");

		        

		        Stream<String> stream =

		        ThreadLocalRandom

		        .current()

		        .longs()

		        .mapToObj(Long::toHexString)

		        .limit(10)

		        .sorted() ;

		        Object[] sorted = stream.toArray() ;

		        for (int i = 0 ; i < sorted.length ; i++) {

		        System.out.println(sorted[i]);

		        }*/
		        
			
	 }
	 
	 
	 
}
