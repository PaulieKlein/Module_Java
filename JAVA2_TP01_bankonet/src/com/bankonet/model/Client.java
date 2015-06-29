package com.bankonet.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Modelise un client de bankonet.
 *
 * <p>Un client est caracterise par :
 * <ul>
 * <li> son identifiant unique
 * <li> son nom
 * <li> son prenom
 * <li> la liste de ses comptes
 * </ul>
 *
 * @author fguibert
 */
public class Client implements Comparable {
	private int identifiant;
	private String nom;
	private String prenom;
	private List<?> compteCourantList;
	private List<?> compteEpargneList;
	
	
	public Client() {}
	
	/**
	 * @param nom
	 * @param prenom
	 * @param identifiant
	 */
	public Client(int identifiant, String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.identifiant = identifiant;
	}
	
	public Client(int identifiant, String nom, String prenom, List<?> ccList, List<?> ceList) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.identifiant = identifiant;
		this.compteCourantList = ccList;
		this.compteEpargneList = ceList;
		
	}
	

	public int compareTo(Object aClient) throws ClassCastException {
		if (!(aClient instanceof Client))
			throw new ClassCastException("Objet de type Client attendu !");
		
		Integer anotherId = ((Client) aClient).getIdentifiant();
		return this.getIdentifiant() - anotherId.intValue();
	}
	
	
	public String toString() {
		 return " ID  : "+this.getIdentifiant() +" - "+
		    	" Nom : "+this.getNom()+" - "+
		    	" Prénom : "+this.getPrenom();
		    		
		
	}
	
	public float calculerAvoirGLobal()
	{
		
		
		List<Compte> tousLesComptes = new ArrayList(this.getComptes());
		float soldeTotal = 0;
		for(Compte myC : tousLesComptes) {
			soldeTotal += myC.getSolde();
		}
		return soldeTotal;
		
	}
	/**
	 * @param compteCourantList The compteCourantList to set.
	 */
	public void setCompteCourantList(List<?> compteCourantList) {
		this.compteCourantList = compteCourantList;
	}
	/**
	 * @param compteEpargneList The compteEpargneList to set.
	 */
	public void setCompteEpargneList(List<?> compteEpargneList) {
		this.compteEpargneList = compteEpargneList;
	}
	





	/**
	 * Retourne la liste des comptes courants du client (de taille 0 si pas de comptes courants).
	 * 
	 *
	 * @return List
	 */
	public List<?> getComptesCourants() {
		return Collections.unmodifiableList(compteCourantList);
	}
	/**
	 * Retourne la liste des comptes d'epargne du client sous forme d'une ArrayList (de taille 0 si pas de compte epargne).
	 * 
	 * @return List
	 */
	public List<?> getComptesEpargne() {
		return Collections.unmodifiableList(compteEpargneList);
	}
	
	public List<Object> getComptes() {
	    ArrayList<Object> compteList = new ArrayList<>();
	    compteList.addAll(compteCourantList);
	    compteList.addAll(compteEpargneList);
	    return Collections.unmodifiableList(compteList);

	}

	public Compte getCompte(int compteId) {
	    List<Object> compteList = this.getComptes();
	    Iterator<Object> compteIte = compteList.iterator();
	    while (compteIte.hasNext()) {
            Compte compte = (Compte) compteIte.next();
            if (compteId == compte.getIdentifiant())
                return compte;
        }
	    return null; 
	}
	
	public int getIdentifiant() {
		return identifiant;
	}
	/**
	 * Retourne le nom du client.
	 *
	 * @return java.lang.String
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * Retourne le prenom du client.
	 * 
	 * @return java.lang.String
	 */
	public String getPrenom() {
		return prenom;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
}
