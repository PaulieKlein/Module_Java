package com.bankonet.jdbc;
import com.bankonet.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Comparator;


public class ClientDao {
	
	private final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private final String DB_URL = "jdbc:mysql:///banque";
	private final String DB_LOGIN = "root";
	private final String DB_PASSWORD = "";
	private Connection connexion;
	
	public ClientDao () throws CreationConnexionException {
		
		try {
			Class.forName(DRIVER_NAME);
			connexion = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PASSWORD);
			
			} catch (ClassNotFoundException ex) {
				throw new CreationConnexionException();
			}catch (SQLException e){
				throw new CreationConnexionException();
			}
		
	}
	
	public void closeConnection() {
		if(connexion != null){
		try {
			
			connexion.close();
			
			} catch (SQLException e) {}
		}
	}
	
	public List lireClients(){
		
		List <Client> listClient =  new ArrayList <Client>();
		String query1 = "SELECT ID, NOM, PRENOM FROM CLIENT";
		Statement st = null;
		ResultSet rs = null;
		
		try {
		st = connexion.createStatement();
		rs = st.executeQuery(query1);
		while(rs.next()){
			listClient.add(new Client(rs.getString("ID"),rs.getString("NOM"),rs.getString("PRENOM")));
		}
		} catch (SQLException e){
			e.printStackTrace();
			}finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) {};
		    try { if (st != null) st.close(); } catch (SQLException e) {};
		}
		return listClient;
	} 
	
	public Client lireClient(int id) {
		
		Client client;
		String query2 = "SELECT ID, NOM, PRENOM FROM CLIENT WHERE ID = ?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
		pst = connexion.prepareStatement(query2);
		pst.setInt(1,id);
		rs = pst.executeQuery();
		while(rs.next()){
		client = new Client(rs.getString("ID"),rs.getString("NOM"),rs.getString("PRENOM"));
		return client;
			
		}
		} catch (SQLException e){
			e.printStackTrace();
			}finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) {};
		    try { if (pst != null) pst.close(); } catch (SQLException e) {};
		}
		
		return null;
	}
	
	public List lireComptesCourant(Client unClient){
		
		List <CompteCourant> listComptesCourant =  new ArrayList <CompteCourant>();
		String query3 = "SELECT ID, LIBELLE, SOLDE, DECOUVERTAUTORISE FROM COMPTE WHERE (DISCRIMINANT = 'CC' && ID_CLIENT=?)";
		
		//String id, String libelle, float solde, float decouvertAutorise
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			pst = connexion.prepareStatement(query3);
			pst.setString(1,unClient.getIdentifiant());
			rs = pst.executeQuery();
		while(rs.next()){
			listComptesCourant.add(new CompteCourant(rs.getString("ID"),rs.getString("LIBELLE"),rs.getFloat("SOLDE"),rs.getFloat("DECOUVERTAUTORISE")));
		}
		} catch (SQLException e){
			e.printStackTrace();
			}finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) {};
		    try { if (pst != null) pst.close(); } catch (SQLException e) {};
		}
		return listComptesCourant;
	} 
	
	public List lireComptesEpargne(Client unClient){
		
		List <CompteEpargne> listComptesEpargne =  new ArrayList <CompteEpargne>();
		String query4 = "SELECT ID, LIBELLE, SOLDE, PLAFOND ,TAUX FROM COMPTE WHERE (DISCRIMINANT = 'CE' && ID_CLIENT=?)";
		
		//
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			pst = connexion.prepareStatement(query4);
			pst.setString(1,unClient.getIdentifiant());
			rs = pst.executeQuery();
		while(rs.next()){
			listComptesEpargne.add(new CompteEpargne(rs.getString("ID"),rs.getString("LIBELLE"),rs.getFloat("SOLDE"),rs.getFloat("TAUX"),rs.getFloat("PLAFOND")));
		}
		} catch (SQLException e){
			e.printStackTrace();
			}finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) {};
		    try { if (pst != null) pst.close(); } catch (SQLException e) {};
		}
		return listComptesEpargne;
	} 
	
	
	
	public void ecrireClient (Client client)  {
		
		String query7 = "INSERT INTO CLIENT (ID,NOM,PRENOM,LOGIN,MOTDEPASSE) VALUES (?,?,?,?,?)";
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
		pst = connexion.prepareStatement(query7);
		pst.setString(1, client.getIdentifiant());
		pst.setString(2, client.getNom());
		pst.setString(3, client.getPrenom());
		pst.setString(4, client.getPrenom());
		pst.setString(5, client.getPrenom());
		
		pst.executeUpdate();
		
		} catch (SQLException e){
			e.printStackTrace();
			}finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) {};
		    try { if (pst != null) pst.close(); } catch (SQLException e) {};
		}	
	}
	
	public void ecrireComptecourant(CompteCourant unCompte, Client unClient) throws SQLException{
		String query8 = "INSERT INTO COMPTE (ID,LIBELLE,SOLDE,ID_CLIENT,DECOUVERTAUTORISE,DISCRIMINANT) VALUES (?,?,?,?,?,'CC')";
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
		pst = connexion.prepareStatement(query8);
		pst.setString(1, unCompte.getIdentifiant());
		pst.setString(2, unCompte.getLibelle());
		pst.setFloat(3, unCompte.getSolde());
		pst.setString(4, unClient.getIdentifiant());
		pst.setFloat(5, unCompte.getDecouvertAutorise());
		
		pst.executeUpdate();
		pst.close();
		
		} catch (SQLException e){
			e.printStackTrace();
			}finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) {};
		    try { if (pst != null) pst.close(); } catch (SQLException e) {};
		}	
	}
	public void ecrireCompteepargne(CompteEpargne unCompte, Client unClient) throws SQLException{
		String query9 = "INSERT INTO COMPTE (ID,LIBELLE,SOLDE,ID_CLIENT,TAUX,PLAFOND,DISCRIMINANT) VALUES (?,?,?,?,?,?,'CE')";
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
		pst = connexion.prepareStatement(query9);
		pst.setString(1, unCompte.getIdentifiant());
		pst.setString(2, unCompte.getLibelle());
		pst.setFloat(3, unCompte.getSolde());
		pst.setString(4, unClient.getIdentifiant());
		pst.setFloat(5, unCompte.getTauxInteret());
		pst.setFloat(6, unCompte.getPlafond());
		
		pst.executeUpdate();
		pst.close();
		
		} catch (SQLException e){
			e.printStackTrace();
			}finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) {};
		    try { if (pst != null) pst.close(); } catch (SQLException e) {};
		}	
	}
	
	public void supprimerClientEtComptes(Client client){
		
		String query5 = "DELETE * FROM COMPTE  WHERE ID_CLIENT = ?";
		String query6 = "DELETE * FROM CLIENT  WHERE ID = ?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
		pst = connexion.prepareStatement(query5);
		pst.setString(2,client.getIdentifiant());
		pst.executeUpdate();
		
		} catch (SQLException e){
			e.printStackTrace();
			}finally {
			try { if (rs != null) rs.close(); } catch (SQLException e) {};
		    try { if (pst != null) pst.close(); } catch (SQLException e) {};
		}
		
		try {
			pst = connexion.prepareStatement(query6);
			pst.setString(1,client.getIdentifiant());
			pst.executeUpdate();
			
			} catch (SQLException e){
				e.printStackTrace();
				}finally {
				try { if (rs != null) rs.close(); } catch (SQLException e) {};
			    try { if (pst != null) pst.close(); } catch (SQLException e) {};
			}	
	}
}
