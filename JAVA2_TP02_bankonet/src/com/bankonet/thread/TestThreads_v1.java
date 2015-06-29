package com.bankonet.thread;

import java.util.*;

import com.bankonet.model.*;

public class TestThreads_v1 {
	
    public static void main(String[] args) {
    	
        Client client = TestThreads_v1.getClientData();

        for (Iterator it = client.getComptesCourants().iterator(); it.hasNext();) {
            CompteCourant compte = (CompteCourant)it.next();
            
            Runnable plus100 = new AlimenteurCompte_v1(compte, new Float(100),
            		new Integer(10000));// Attends 10 secondes
            Runnable minus100 = new AlimenteurCompte_v1(compte, new Float(-100),
            		new Integer(5000));// Attends 5 secondes
            
            Thread thread1 = new Thread(plus100);
            Thread thread2 = new Thread(minus100);
            
            thread1.start();
            thread2.start();
        }

    }

    
    
    
    
    public static Client getClientData() {
        Client client = new Client();
        client.setIdentifiant(new Integer(1));
        client.setNom("Hugo");
        client.setPrenom("Victor");
        
        List<CompteCourant> compteCourantList = new ArrayList<CompteCourant>();
        compteCourantList.add(new CompteCourant(
        		new Integer(4), "Compte Courant 1",
        		new Float(10.0f),
                new Float(200.0f)));
        client.setCompteCourantList(compteCourantList);

        return client;
    }
}
