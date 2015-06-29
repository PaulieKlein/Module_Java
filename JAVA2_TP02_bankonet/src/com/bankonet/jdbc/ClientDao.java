package com.bankonet.jdbc;

import java.sql.*;
import java.util.*;

import com.bankonet.model.Client;
import com.bankonet.model.Compte;
import com.bankonet.model.CompteCourant;
import com.bankonet.model.CompteEpargne;

public class ClientDao {
	
    private final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql:///banque2";
    private final String DB_LOGIN = "root";
    private final String DB_PASSWORD = "";
    private Connection connexion;

    public ClientDao() throws CreationConnexionException {
        try {
            // Le nom de la classe n�est connu qu�au moment de l�ex�cution
            // d'o� l'instruction Class.forName
            // Chargement du driver JDBC
            Class.forName(DRIVER_NAME);
            // Obtention d'une connexion aupr�s du DriverManager
            // et stockage dans l'attribut connexion
            connexion = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PASSWORD);
            
        } catch (ClassNotFoundException ex) {
            System.err.println("Impossible de charger le driver : "
            		+ "la classe du driver doit se situer dans le classpath !");
            throw new CreationConnexionException(
                    "Erreur lors de la cr�ation de la connexion au r�f�rentiel !");
        } catch (SQLException e) {
            throw new CreationConnexionException(
                    "Erreur lors de la cr�ation de la connexion au r�f�rentiel");
        }
    }

    public void closeConnection() {
    	if (connexion != null) {
    		
    			try {
					connexion.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		
    	}
    }
    
    /**
     * Retourne l'ensemble des clients de la base de donn�es
     * (sans leurs donn�es compte)
     *
     * @return une collection de Client
     */
    public List<Client> lireClients() {
        List<Client> collectionClients = new ArrayList<Client>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connexion.createStatement();
            rs = stmt.executeQuery("SELECT * FROM CLIENT");
            while (rs.next())
                collectionClients.add(
                	new Client(
                		new Integer(rs.getInt("ID")),
                		rs.getString("NOM"),
                        rs.getString("PRENOM")));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null)
                try {
                    stmt.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            if (rs != null)
                try {
                    rs.close();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
        }
        return collectionClients;
    }
    
    /**
     * Charge un client (c'est � dire ses propres donn�es plus ses comptes)
     * depuis la base de donn�es. Un objet de type Client est instanci�.
     *
     * @return Le client charg�.
     * @param numero
     *            Le numero du client � rechercher.
     */
    public Client lireClient(int id) {
        Client cl = null;
        PreparedStatement stmt = null;
        ResultSet curseur = null;
        try {
            stmt = connexion.prepareStatement("SELECT ID, NOM, PRENOM FROM client WHERE ID= ?");
            stmt.setInt(1, id);
            curseur = stmt.executeQuery();
            if (curseur.next()) {
                String nom = curseur.getString("NOM");
                String prenom = curseur.getString("PRENOM");
                cl = new Client(new Integer(id), nom, prenom);
            }
            
            cl.setCompteCourantList(lireComptesCourant(cl));
            cl.setCompteEpargneList(lireComptesEpargne(cl));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null)
                try {
                    stmt.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            if (curseur != null)
                try {
                    curseur.close();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
        }

        return cl;
    }
    
    public List<Compte> lireComptesCourant(Client unClient) {
        List<Compte> collectionComptesCourant = new ArrayList<Compte>();
        PreparedStatement pms = null;
        ResultSet curseur = null;
        try {
            pms = connexion.prepareStatement("SELECT ID, LIBELLE, SOLDE"
            		+", DECOUVERTAUTORISE FROM compte WHERE ID_CLIENT=? "
            		+ "AND DISCRIMINANT='CC'");
            pms.setInt(1, unClient.getIdentifiant());
            curseur = pms.executeQuery();
            while (curseur.next()) {
                collectionComptesCourant.add(
                	new CompteCourant(
                		new Integer(curseur.getInt("ID")),
                		curseur.getString("LIBELLE"),
                        new Float(curseur.getFloat("SOLDE")),
                        new Float(curseur.getFloat("DECOUVERTAUTORISE"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pms != null)
                try {
                    pms.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            if (curseur != null)
                try {
                    curseur.close();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
        }
        return collectionComptesCourant;
    }

    public List<Compte> lireComptesEpargne(Client unClient) {
        List<Compte> collectionComptesEpargne = new ArrayList<Compte>();
        PreparedStatement pms = null;
        ResultSet curseur = null;
        try {
            pms = connexion.prepareStatement("SELECT ID, LIBELLE, SOLDE, "
            		+ "PLAFOND, DISCRIMINANT, TAUX FROM COMPTE WHERE ID_CLIENT=? "
            		+ "AND DISCRIMINANT='CE'");
            pms.setInt(1, unClient.getIdentifiant());
            curseur = pms.executeQuery();
            while (curseur.next()) {
                collectionComptesEpargne.add(
                	new CompteEpargne(
                		new Integer(curseur.getInt("ID")),
                		curseur.getString("LIBELLE"),
                        new Float(curseur.getFloat("SOLDE")),
                        new Float(curseur.getFloat("PLAFOND")),
                        new Float(curseur.getFloat("TAUX"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pms != null)
                try {
                    pms.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            if (curseur != null)
                try {
                    curseur.close();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
        }
        return collectionComptesEpargne;
    }
    
    /**
     * Calcul du prochain num�ro de compte qui sera ins�r� en base de donn�es.
     * Cette donn�e est masqu�e � l'utilisateur d'o� ce calcul.
     *
     * R�cup�ration du num�ro maximun existant dans la table Compte.
     * A ce num�ro est ajout� 1.
     *
     * Si une java.lang.Exception survient l'exception com.bankonet.jdbc.ErreurCalculException
     * est propag�e
     */
    private Integer genererNouveauNumeroCompte() throws ErreurCalculException {
        int newId = 1;
        try {
            PreparedStatement psm = connexion.
            	prepareStatement("SELECT MAX(ID) as nb FROM compte");
            ResultSet curseur = psm.executeQuery();
            if (curseur.next()) {
                newId = curseur.getInt("nb")+1;
                if (curseur.next()) {
                    int nextNewId = curseur.getInt("nb")+1;
                    if (nextNewId>newId) newId=nextNewId;
                }
            }
        } catch (Exception ex) {
            throw new ErreurCalculException();
        }
        return new Integer(newId);
    }
    
    /**
     * Calcul du prochain num�ro de client qui sera ins�r� en base de donn�es.
     * Cette donn�e est masqu�e � l'utilisateur d'o� ce calcul.
     *
     * R�cup�ration du num�ro maximun existant dans la table Compte.
     * A ce num�ro est ajout� 1.
     *
     * Si une java.lang.Exception survient l'exception com.bankonet.jdbc.ErreurCalculException
     * est propag�e
     */
    private Integer genererNouveauNumeroClient() throws ErreurCalculException {
        int newId = 1;
        try {
            PreparedStatement psm = connexion.
            	prepareStatement("SELECT MAX(ID) as nb FROM client");
            ResultSet curseur = psm.executeQuery();
            if (curseur.next()) {
                newId = curseur.getInt("nb")+1;
                if (curseur.next()) {
                    int nextNewId = curseur.getInt("nb")+1;
                    if (nextNewId>newId) newId = nextNewId;
                }
            }
        } catch (Exception ex) {
            throw new ErreurCalculException();
        }
        return new Integer(newId);
    }
    
    /**
     * Insertion d'un nouveau client dans la base de donn�es.
     */
    public void ecrireClient(Client client) {
        PreparedStatement stmtClient = null;
        try {
            // La table client possede une colonne motdepasse,
            // Un objet client ne possede pas de champ mot de passe.
            // Le mot de passe est initialis� avec une cha�ne vide.

            stmtClient = connexion
               .prepareStatement("INSERT INTO Client (ID, NOM, PRENOM) VALUES (?,?,?)");

            // G�n�rer un nouvel identifiant pour le nouveau Client
            try {
            	client.setIdentifiant(this.genererNouveauNumeroClient());
			} catch (ErreurCalculException e2) {
				e2.printStackTrace();
			}
			stmtClient.setInt(1, client.getIdentifiant());
            stmtClient.setString(2, client.getNom());
            stmtClient.setString(3, client.getPrenom());
            
            stmtClient.executeUpdate();
            
            // Insertion de chacun des comptes du client dans la table
            // correspondante
            Iterator comptesIte = client.getComptes().iterator();

            while (comptesIte.hasNext()) {
                Compte cpt = (Compte) comptesIte.next();
                try {
                    // Si c'est un compte de type CompteCourant...
                    CompteCourant cc = (CompteCourant) cpt;

                    try {
                        // Insertion dans la table des comptes courant
                        ecrireComptecourant(cc, client);
                    } catch (SQLException e) {
                        System.out
                         	.println("Erreur lors de l'ajout d'un compte courant ! : "+e.getMessage());
                    }
                } catch (ClassCastException e) {
                    try {
                        // Si c'est un compte de type CompteEpargne...
                        CompteEpargne ce = (CompteEpargne) cpt;
                        try {
                            //.Insertion dans la table des comptes �pargne
                            ecrireCompteepargne(ce, client);
                        } catch (SQLException sqlE) {
                            System.out
                              .println("Erreur lors de l'ajout d'un compte �pargne ! : "+e.getMessage());
                        }
                    } catch (ClassCastException e1) {
                        System.out
                        	.println("Type de compte inconnu !");
                    }
                }
            }
        } catch (SQLException ex) {
            System.out
            	.println("Erreur lors de l'ajout d'un client (ses comptes n'ont pas �t� ajout�s) !");
            System.out.println("Erreur technique :" + ex.getLocalizedMessage());
        } finally {
            try {
                if (stmtClient != null)
                    stmtClient.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
	public void ecrireComptecourant(CompteCourant unCompte, Client unClient)
            throws SQLException {
        PreparedStatement stmtCompte = null;

        stmtCompte = connexion
        	.prepareStatement("INSERT INTO COMPTE (ID, LIBELLE, SOLDE, ID_CLIENT, DECOUVERTAUTORISE, DISCRIMINANT) VALUES (?,?,?,?,?, 'CC')");

        // G�n�rer un identifiant � appliquer pour un nouveau Compte
        try {
			unCompte.setIdentifiant(this.genererNouveauNumeroCompte());
		} catch (ErreurCalculException e) {
		}
		stmtCompte.setInt(1, unCompte.getIdentifiant());
        stmtCompte.setString(2, unCompte.getLibelle());
        stmtCompte.setFloat(3, unCompte.getSolde());
        stmtCompte.setInt(4, unClient.getIdentifiant());
        stmtCompte.setFloat(5, unCompte.getDecouvertAutorise());
        stmtCompte.executeUpdate();
        stmtCompte.close();
    }

	public void ecrireCompteepargne(CompteEpargne unCompte, Client unClient)
            throws SQLException {
        PreparedStatement stmtCompte = connexion
        	.prepareStatement("INSERT INTO COMPTE (ID, LIBELLE, SOLDE, ID_CLIENT, PLAFOND, TAUX , DISCRIMINANT) VALUES (?,?,?,?,?,?, 'CE')");
        
        // G�n�rer un identifiant � appliquer pour un nouveau Compte
        try {
			unCompte.setIdentifiant(this.genererNouveauNumeroCompte());
		} catch (ErreurCalculException e) {
		}
		stmtCompte.setInt(1, unCompte.getIdentifiant());
        stmtCompte.setString(2, unCompte.getLibelle());
        stmtCompte.setFloat(3, unCompte.getSolde());
        stmtCompte.setInt(4, unClient.getIdentifiant());
        stmtCompte.setFloat(5, unCompte.getPlafond());
        stmtCompte.setFloat(6, unCompte.getTauxInteret());
        stmtCompte.executeUpdate();
        stmtCompte.close();
    }
	
	/**
     * Suppression d'un client dans la base de donn�es.
     */
    @SuppressWarnings("resource")
	public void supprimerClientEtComptes(Client client) {
        PreparedStatement stmtClient = null;
        try {
            // Pour g�rer la transaction,  il faut avoir la main sur l'autocommit

        	// Garder l'ancienne valeur pour la r�tablir � la fin.
        	boolean autoCommit = connexion.getAutoCommit();
        	connexion.setAutoCommit(false);
        	
        	// D'abord �ter les comptes
        	stmtClient = connexion
            	.prepareStatement("DELETE from COMPTE WHERE ID_CLIENT=?");
            stmtClient.setInt(1, client.getIdentifiant());
            stmtClient.executeUpdate();

            // Puis le client
		    stmtClient = connexion.prepareStatement("DELETE from CLIENT WHERE ID=?");
		    stmtClient.setInt(1, client.getIdentifiant());
            stmtClient.executeUpdate();
            
            
            connexion.commit(); // Commit de la suppression

        	// Et r�tablir l'ancienne valeur de AutoCommit.
            connexion.setAutoCommit(autoCommit);
            
            
            
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la suppression du client id="
            		+ client.getIdentifiant());
			ex.printStackTrace();
            try {
				connexion.rollback();
			} catch (SQLException e) {
	            System.out.println("Erreur lors du rollBack !");
				e.printStackTrace();
			}
        } finally {
            try {
                if (stmtClient != null)
                    stmtClient.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    
    private Connection getConnexion() {
        return connexion;
    }

    private void fermerConnexion() {
        if (getConnexion() != null) {
            try {
                getConnexion().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * R�cup�ration dans une collection de tous les comptes du client
     *
     * @param unClient
     *            Client pour lequel on veut avoir l'ensemble de ses comptes
     * @return une List<Compte> de l'ensemble des comptes du client
     */
    public List<Compte> lireTousLesComptes(Client unClient) {
        List<Compte> listeComptes = lireComptesCourant(unClient);
        listeComptes.addAll(lireComptesEpargne(unClient));
        return listeComptes;
    }
}