package com.bankonet.test;
import com.bankonet.model.Client;
import com.bankonet.model.CompteCourant;
import com.bankonet.model.CompteEpargne;
import com.bankonet.model.Compte;
public class TestClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CompteCourant compteCourant1 = new CompteCourant("C1","courant1",-100,10);
		CompteCourant compteCourant2 = new CompteCourant("C2","courant2",200,20);
		CompteCourant compteCourant3 = new CompteCourant("C3","courant3",300,5);
		
		CompteEpargne compteEpargne1 = new CompteEpargne("E1","epargne1",1000,10);
		CompteEpargne compteEpargne2 = new CompteEpargne("E2","epargne2",200,5);
		CompteEpargne compteEpargne3 = null;
		
		
		Client client1 = new Client("id1","klein1","pauline1",compteCourant1,compteEpargne1);
		Client client2 = new Client("id2","klein2","pauline2",compteCourant2,compteEpargne2);
		Client client3 = new Client("id3","klein3","pauline3",compteCourant3, compteEpargne3);
		
		Client [] clientTab =  {client1,client2,client3};
		
	
		for(int i = 0;i<clientTab.length;i++) {
			if ( clientTab[i].getCompteCourant()==null){
				System.out.println(clientTab[i].toString());
				
			}else if (clientTab[i].getCompteEpargne()==null){
				System.out.println(clientTab[i].toString());
			} else {
			
			System.out.println(clientTab[i].toString());
			}
		
		}
		
		System.out.println("la demande de crédit est " + compteCourant1.creditAutorise(100) );
		System.out.println("la demande de débit est " + compteCourant2.debitAutorise(2000) );
		System.out.println("la demande de débit est " + compteCourant1.debitAutorise(1000) );
		
		
	}

}
