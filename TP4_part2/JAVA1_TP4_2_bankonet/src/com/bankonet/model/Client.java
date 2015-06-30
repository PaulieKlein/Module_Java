package com.bankonet.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Comparator;

import org.apache.log4j.Logger;
import java.lang.*;

import com.bankonet.test.TestClient;

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
	private String identifiant;
	private String nom;
	private String prenom;
	private List<?> compteCourantList;
	private List<?> compteEpargneList;
	private List<?> compteList;
	
	final static Logger logger = Logger.getLogger(Client.class);
	
	/**
	 * @param nom
	 * @param prenom
	 * @param identifiant
	 */
	
	
	public Client(String identifiant, String nom, String prenom) throws InvalidAttributesException {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.identifiant = identifiant;
		
		logger.debug(" ID  : "+this.getIdentifiant() +" - "+
		    	" Nom : "+this.getNom()+" - "+
		    	" Prénom : "+this.getPrenom());
		
		if(identifiant == null){
			 throw new InvalidAttributesException();
		}
	}
	
	public Client(String identifiant, String nom, String prenom, List<?> ccList, List<?> ceList) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.identifiant = identifiant;
		this.compteCourantList = ccList;
		this.compteEpargneList = ceList;

		
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

	public Compte getCompte(String compteId) {
	    List<Object> compteList = this.getComptes();
	    Iterator<Object> compteIte = compteList.iterator();
	    while (compteIte.hasNext()) {
            Compte compte = (Compte) compteIte.next();
            if (compteId.equals(compte.getIdentifiant()))
                return compte;
        }
	    return null; 
	}
	
	public String getIdentifiant() {
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
	
	
	public void creerCompte(Compte compte){
		List<Object> compteList = this.getComptes();
	    compteList.add(compte);
	}
	
	public void supprimerCompte(Compte compte){
		List<Object> compteList = this.getComptes();
		if(compte!=null){
			compteList.remove(compte);
		}
	    
	}
	
	public Compte retournerCompte(String numero){
		List<Object> compteList = this.getComptes();
		
		Iterator <Object> cl = compteList.iterator();
		while(cl.hasNext()){
			Compte compte = (Compte) cl.next();
			if(compte.getIdentifiant().equals(numero)){
				return compte;
			}
		}
		
		return null;		
	}
	
	public void supprimerCompte(String numero){
		List<Object> compteList = this.getComptes();
		compteList.remove(retournerCompte(numero));
	}
	
	public int compareTo(Object aClient) throws ClassCastException{
		if(aClient instanceof Client){
			Client aClienttmp=(Client)aClient;
			int age = this.getIdentifiant().compareTo( aClienttmp.getIdentifiant());
			if(age>0){
				return 1 ;
			} else{return -1;}
		}else {
			throw new ClassCastException("le paramètre n'est pas une instance de Client");
		}
		
		
	}
}
