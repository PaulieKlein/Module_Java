package com.bankonet.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.bankonet.model.*;

import org.apache.log4j.*;

public class TestClient {
	
	final static Logger logger = Logger.getLogger(TestClient.class);

	 public static void main(String[] args) throws DebitException {
		
		 try {
		
		// Utilisation d'une collection : cr�ation de la liste des comptes courants/epargne
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
		listClient.add(new Client(null,"GUIBERT", "Fabien", listCompteCourant1, listCompteEpargne1));
		listClient.add(new Client("2","TOTO", "Titi", listCompteCourant2, listCompteEpargne2));
		listClient.add(new Client("3","DURAND", "Jacques", listCompteCourant3,new ArrayList<>()));
		
		 for(Client myClient : listClient) {
			 logger.info("");
			 logger.info(myClient.toString());
			 logger.info("Avoir global : "+myClient.calculerAvoirGLobal()+" �");
			    for(Object myCompte : myClient.getComptes()) {
			    	logger.info(myCompte.toString());
			    }
			    
//			    for(Object myCE : myClient.getComptesEpargne()) {
//		    		System.out.println(myCE.toString2());
//			    }
			    
		 }
		 	
		 } catch (Exception e) {logger.error(e,e);}
		 
		 		CompteCourant compte1 =new CompteCourant("1", "compte courant 1", 0, 1000);
		 		CompteCourant compte2 =new CompteCourant("2", "compte courant 2", 20, 1000);
				compte1.effectuerVirement(compte2,5F);
				logger.info("\nVirement de 5 : \nSolde du Compte 2 : " + compte2.getSolde() + "\nSolde du Compte 1 : " + compte1.getSolde());
		 
		 
		
			
	 }
	 
	 
	 
}
