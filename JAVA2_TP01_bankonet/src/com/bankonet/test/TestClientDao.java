package com.bankonet.test;

import java.util.*;

import com.bankonet.jdbc.ClientDao;
import com.bankonet.jdbc.CreationConnexionException;
import com.bankonet.model.Client;
import com.bankonet.model.Compte;

public class TestClientDao {

	public static void main(String[] args) {
		TestClientDao tcd = new TestClientDao();
		tcd.runTests();
	}

	public void runTests() {
		ClientDao clientDao = null;
		try {
			clientDao = new ClientDao();
		} catch (CreationConnexionException e) {
			e.printStackTrace();
		}
		testLectureClients(clientDao);
		testAjoutSuppressionClients(clientDao);
	}

	private void testLectureClients(ClientDao clientDao) {
		List<Client> clients = clientDao.lireClients();
		System.out.println("");
		System.out.println("LECTURE DES CLIENTS");
		System.out.println("*******************");
		for (Client client : clients) {
			//client.toString();
			afficheClient(clientDao, client);
		}
	}

	private void afficheClient(ClientDao clientDao, Client client) {
		System.out.println(client);
		List<Compte> comptes = clientDao.lireTousLesComptes(client);
		if (comptes != null && comptes.size() > 0) {
			for (Compte compte : comptes) {
				System.out.println(compte);
			}
		}
	}
	
	private void testAjoutSuppressionClients(ClientDao clientDao) {

		// Récupérer des clients à ajouter

		List<Client> clients = DonneesTest.construitEchantillonClients();

		// Ajouter quelques clients
		for (Client client : clients) {
			clientDao.ecrireClient(client);
		}

		// Afficher la liste des clients pour voir si l'ajout a bien eu lieu
		System.out.println("");
		System.out.println("LECTURE DES CLIENTS APRES AJOUT");
		System.out.println("*******************************");
		afficheClientEnBase(clientDao);

		// Les supprimer
		for (Client client : clients) {
			clientDao.supprimerClientEtComptes(client);
		}

		// Afficher la liste des clients pour voir si l'ajout a bien eu lieu
		System.out.println("");
		System.out.println("LECTURE DES CLIENTS APRES SUPPRESSION");
		System.out.println("*******************************");
		afficheClientEnBase(clientDao);

	}

	private void afficheClientEnBase(ClientDao clientDao) {
		List<Client> clients = clientDao.lireClients();
		for (Client client : clients) {
			afficheClient(clientDao, client);
		}

	}
}