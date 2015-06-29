package com.bankonet.test;

import com.bankonet.model.*;
import com.bankonet.jdbc.*;

import java.sql.SQLException;
import java.util.List;

public class TestClientDao {
	
	private void testLectureClients(ClientDao clientDao)throws SQLException{
		
		Client client2 = new Client("4","Farau","Romain");
		CompteCourant cc = new CompteCourant("41","courant pauline",700F,50F);
		CompteEpargne ce = new CompteEpargne("42","epargne pauline",500F,3.1F,10000F);
		clientDao.ecrireClient(client2);
		clientDao.ecrireComptecourant(cc,client2);
		clientDao.ecrireCompteepargne(ce,client2);
	}
	
	private void testAjoutSuppressionClients(ClientDao clientDao){
		
		Client client = new Client("5","Klein","Pauline");
		clientDao.supprimerClientEtComptes(client);
		
	}



	public static void main(String[] args) throws CreationConnexionException,SQLException {
		// TODO Auto-generated method stub
		
		ClientDao clientDao = new ClientDao();
		
		/*Client client2 = new Client("4","Farau","Romain");
		CompteCourant cc = new CompteCourant("41","courant romain",700F,50F);
		CompteEpargne ce = new CompteEpargne("42","epargne romain",500F,3.1F,10000F);
		clientDao.ecrireClient(client2);
		clientDao.ecrireComptecourant(cc,client2);
		clientDao.ecrireCompteepargne(ce,client2);*/
		
		Client client1 = new Client ("1","Dupond","David");
		System.out.print(clientDao.lireClients());
		System.out.print("\n" + clientDao.lireClient(3));
		System.out.print("\n" + clientDao.lireComptesCourant(client1));
		System.out.print("\n" + clientDao.lireComptesEpargne(client1));
		
		/*List <Client> clients = clientDao.lireClients();
		for (Client client : clients){
			System.out.print(client.toString());
		}*/
	}
	

}
