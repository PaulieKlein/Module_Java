package com.bankonet.test;

import java.lang.reflect.Method;
import java.util.*;

import com.bankonet.model.Client;

public class GenerateBeansTest {

	public static void main(String[] args) {
		GenerateBeansTest gb = new GenerateBeansTest();
		Client client = new Client();
		

		// Exemple de chargement par réflexion
		//gb.generateBeanInstance(client);
		
		// Exemple de chargement par valeurs
		gb.generateBean(client);
		
	}


	public void generateBeanInstance(Client client) {
		// Récupérer des couples clé/valeur d'éléments à charger dans l'objet
		// passé en paramètre, chargé le bean par réflexion
		// et afficher le client résultat
		Map clientData = getClientData();
		Set clientDataKeys = clientData.keySet();
		Iterator clientDataKeysIte = clientDataKeys.iterator();
		try {
			Class clientClass = client.getClass();
			while (clientDataKeysIte.hasNext()) {
				String key = (String) clientDataKeysIte.next();
				Class[] parameterTypes = new Class[] {
						  clientData.get(key).getClass()
						};
				
				String methodName = "set" + key;
				Method setterMethod = clientClass.getMethod(methodName,parameterTypes);
				Object[] arguments = new Object[] { getClientData().get(key) };
				System.out.println("Invocation de la methode trouvee ("
						+ setterMethod + ")...");
				setterMethod.invoke(client, arguments);
			}
			System.out.println("");
			System.out.println("2eme methode d'instanciation (par réflexion "
					+ "avec la methode generateBeanInstance) :");
			System.out.println("");
			this.print(client);
		} catch (Exception e) {
			System.out.println("Construction de l'objet impossible !");
			e.printStackTrace();
		}
	}

	public Map getClientData() {
		Map dataBeans = new HashMap();
		dataBeans.put("Identifiant", new Integer(43));
		dataBeans.put("Prenom", "Marcel");
		dataBeans.put("Nom", "Aymé");
		return dataBeans;
	}

	

	public void generateBean(Client client) {
		// Récupérer des couples clé/valeur d'éléments à charger dans l'objet
		// passé en paramètre, charger le bean par valeurs
		// et afficher le client résultat
		Map clientData = this.getClientData();
		Set clientDataKeys = clientData.keySet();
		Iterator clientDataKeysIte = clientDataKeys.iterator();
		String key = null, nom = null, prenom;
		
		while (clientDataKeysIte.hasNext()) {
			key = (String) clientDataKeysIte.next();
			if ("Identifiant".equals(key)) {
				Integer value = (Integer) getClientData().get(key);
				client.setIdentifiant(value);
			} else if ("Nom".equals(key)) {
				nom = (String) getClientData().get(key);
				client.setNom(nom);
			} else if ("Prenom".equals(key)) {
				prenom = (String) getClientData().get(key);
				client.setPrenom(prenom);
			}
		}
		System.out.println("");
		System.out.println("1ere methode d'instanciation "
				+ "(par la methode generateBean) :");
		System.out.println("");
		this.print(client);
	}
	
	public void print(Client client) {
		System.out.println("- client");
		System.out.println("	Identifiant = " + client.getIdentifiant());
		System.out.println("	Prenom = " + client.getPrenom());
		System.out.println("	Nom = " + client.getNom());
	}
/*
	public Map getCompteByRandomData() {
		if (System.currentTimeMillis() % 2 == 0) {
			return getCompteCourantData();
		} else {
			return getCompteEpargneData();
		}
	}

	public Map getCompteCourantData() {
		Map dataBeans = new Hashtable();
		dataBeans.put("Libelle", "Compte courant 1");
		dataBeans.put("Identifiant", "43");
		dataBeans.put("Solde", "100.0");
		dataBeans.put("DecouvertAutorise", "100.0");
		return dataBeans;
	}

	public Map getCompteEpargneData() {
		Map dataBeans = new Hashtable();
		dataBeans.put("Libelle", "Compte courant 1");
		dataBeans.put("Identifiant", "43");
		dataBeans.put("Solde", "100.0");
		dataBeans.put("TauxInteret", "10.0");
		dataBeans.put("Plafond", "10000.0");
		return dataBeans;
	}*/

}
