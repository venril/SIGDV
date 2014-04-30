package fr.demos.formation.sigdv.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class ProduitDAOMySQL implements ProduitDAO {

	private static final int NB_CHAMPS = 4;
	
	private static final String NOM_DRIVER="com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/sigdv";
	private static final String user = "root";
	private static final String password = "manager";
	
	private DataSource ds;

	public ProduitDAOMySQL() throws RuntimeException {
		Context ic = null;
		/*
		try {
			// créer un contexte dans l'annuaire
			ic = new InitialContext(); 
			System.out.println("IC"+ic);
			System.out.println("AVANT DATASOURCE !!");
			//ds = (DataSource)ic.lookup("jdbc/sigdv");
			ds = (DataSource)ic.lookup("jdbc/sigdv");
			System.out.println("APRES DATASOURCE !!");
		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
		 Context ic = null;
		try {
			ic = new InitialContext(); // créer un contexte dans l'annuair
			ds = (DataSource) ic.lookup("jdbc/dvdtheque");
		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		 * */		

	}
	
	// Rechercher un fournisseur dans la table "Fournisseurs":
	@SuppressWarnings("finally")
	public Fournisseur findFournisseur(Fournisseur four) throws SQLException {
		Fournisseur fournisseur = null;
		Connection connexion = null;
		ResultSet rs;
		
		try {
			// driver MySQL
			Class.forName(NOM_DRIVER); 
			// Connexion à la base de données:
			connexion = DriverManager.getConnection(url, user, password);
	
			// Preparation de l'objet qui gère la requête:
			PreparedStatement statement = connexion.prepareStatement("SELECT * FROM fournisseurs WHERE nom=?");
			statement.setString(1,four.getNom());
			rs = statement.executeQuery();
			
			// Verification si le resultat n'est pas vide:
			if (rs.next()) {
				String nom = rs.getString("nom");
				boolean resultat = four.getNom().equalsIgnoreCase(nom);
				
				// Le cas où le fournisseur est déjà present en base de donnéées:
				if (resultat == true) {
					int id = rs.getInt("id");
					fournisseur = new Fournisseur(id, nom);
				}
			}
			
			return fournisseur;
		} finally {
			if (connexion != null) connexion.close();
			return fournisseur;
		} // Fin Try.
		
	} // Fin findFournisseur.

	@SuppressWarnings("finally")
	public Fournisseur findFournisseurById(int id) throws SQLException {
		Fournisseur fournisseur = null;
		Connection connexion = null;
		ResultSet rs;
		
		try {
			// driver MySQL
			Class.forName(NOM_DRIVER); 
			// Connexion à la base de données:
			connexion = DriverManager.getConnection(url, user, password);
	
			// Preparation de l'objet qui gère la requête:
			PreparedStatement statement = connexion.prepareStatement("SELECT * FROM fournisseurs WHERE id=?");
			statement.setInt(1,id);
			rs = statement.executeQuery();
			
			// Verification si le resultat n'est pas vide:
			if (rs.next()) {
				String nom = rs.getString("nom");
				/*
				String adresse = rs.getString("adresse");
				String telephone = rs.getString("telephone");
				String email = rs.getString("email");  */
				
				// Le cas où le fournisseur est déjà present en base de donnéées:
				if (!nom.equals("") || nom != null) {
					fournisseur = new Fournisseur(id, nom);
					//fournisseur = new Fournisseur(id, nom, adresse, telephone, email)
				}
			}
			
			return fournisseur;
		} finally {
			if (connexion != null) connexion.close();
			//System.out.println("RESULTAT DE LA REQUETTE: "+resultat);
			return fournisseur;
		} // Fin Try.
		
	} /* Fin findFournisseurById. */
	
	
	// Methode pour savoir si un fournisseur existe déjà en base de donnees:
	@SuppressWarnings("finally")
	public boolean existeFournisseur(Fournisseur fournisseur) throws SQLException {
		boolean resultat = false;
		Connection connexion = null;
		ResultSet rs;
		
		try {
			// driver MySQL
			Class.forName(NOM_DRIVER); 
			// Connexion à la base de données:
			connexion = DriverManager.getConnection(url, user, password);
									
			// La requette à lancer pour verifier l'existence du fournisseur en base:
			//String SQL = "SELECT * FROM fournisseurs WHERE nom=?";
			
			// Preparation de l'objet qui gère la requête:
			PreparedStatement statement = connexion.prepareStatement("SELECT * FROM fournisseurs WHERE nom=?");
			statement.setString(1,fournisseur.getNom());
			rs = statement.executeQuery();
			if (rs.next()) {
				String nom = rs.getString("nom");
				resultat = fournisseur.getNom().equalsIgnoreCase(nom);
				
				// Le cas où le fournisseur est déjà present en base de donnéées:
				if (resultat == true) {
					int id = rs.getInt("id");
					fournisseur.setId(id);
				}
			}
			return resultat;
			
			//resultat = statement.execute();
			
			//System.out.println("Resultat de la requette: "+resultat);
		} /*catch (Exception e) {
			e.printStackTrace();
		}*/finally {
				if (connexion != null) connexion.close();
				//System.out.println("RESULTAT DE LA REQUETTE: "+resultat);
				return resultat;
		}
	} /* Fin methode existeFournisseur */

	
	// Methode de chargement de produit via un fichier
	public Collection<Produit> chargerProduit(String fichier) throws Exception {
		
		// Initialisation de la connexion
		Connection connexion = null;
		
		// Definition de la liste des produits resultante:
		List<Produit> listProduits = new ArrayList<>();
		try {
			//FileReader fic= new FileReader("C:/Users/BEN/Documents/CQP/STAGE2014-01/SWSandro/Docs/FicherProduit.csv");
			FileReader fic= new FileReader(fichier);
			BufferedReader br = new BufferedReader (fic);
			String line=null;
			String [] donnees;
			/*List<Produit> produits = new ArrayList<>();
			Collection<Produit> produits = new Collection<>(); */
			Produit produit;
			
			Class.forName(NOM_DRIVER); // driver MySQL
			// Connexion à la base de données:
			System.out.println("connexion = DriverManager.getConnection(url, user, password);");
			connexion = DriverManager.getConnection(url, user, password);
			// Preparation de l'objet qui gère la requête:
			Statement statement = connexion.createStatement();
			
			// Lecture du fichier ligne par ligne:
			while ((line=br.readLine()) != null) {
				//System.out.println(line);
				donnees = line.split(";");
				
				// On verifie si la ligne lu est correcte:
				if (donnees.length == NB_CHAMPS) {
					// Le fournisseur correspondant au produit:
					Fournisseur fournisseur = new Fournisseur(donnees[0]);
					
					// Requêt d'insertion d'un fournisseur en base de données:
					String fournisseurSQL = "INSERT INTO Fournisseurs (nom) VALUES ('"+donnees[0]+"')";
					
					// Verification si le fournisseur existe en base de données:					
					if ( !this.existeFournisseur(fournisseur) ) {
						//System.out.println("Resultat de la requête: "+this.existeFournisseur(fournisseur));
						statement.executeUpdate(fournisseurSQL);
												
						// On recupère le nom et id du fournissuer en BD:
						Fournisseur four = this.findFournisseur(fournisseur);
						
						// On met à jour l'id du fournisseur:
						fournisseur.setId(four.getId());
						
						System.out.println("Création du fournisseur { "+fournisseur.getNom()+" } terminée ...");
					} else {
						System.out.println("Le fournisseur "+fournisseur.getNom()+" est déjà enregistré ...");
					}
					
					// Initialisation du produit à inserrer en base:
					String nomProduit = donnees[1];
					int qteProduit = Integer.parseInt(donnees[2]);
					// double prixVente = Integer.parseInt(donnees[3]);
					double prixVente = Integer.parseInt(donnees[3]);
					
					// Insertion d'un produit dans la base de données:
					String produitSQL = "INSERT INTO Produits (nom, prix, quantite, fournisseur) VALUES ('"+nomProduit+"', '"+
							prixVente+"', '"+qteProduit+"', '"+fournisseur.getId()+"')";
					
					statement.executeUpdate(produitSQL);
					
					Produit prd = this.findByName(nomProduit);
					int id = prd.getId();
					System.out.println("id_DB: "+id);
					produit = new Produit(id, nomProduit, prixVente, qteProduit, fournisseur);
					listProduits.add(produit);
					
					System.out.println(donnees[0]);					
				}
				else {
					System.err.println("La ligne: "+line+" ... n'est pas au bon format !!");
				}
			} // while
			//br.reset();
			fic.close();
			
			return listProduits;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return listProduits;
		
	} // Fin methode chargerProduits.
	
	
	@SuppressWarnings("finally")
	@Override
	public Produit findById(int id) throws Exception {
		
		Produit produit = null;
		Connection connexion = null;
		ResultSet rs;
		
		try {
			// driver MySQL
			Class.forName(NOM_DRIVER); 
			// Connexion à la base de données:
			connexion = DriverManager.getConnection(url, user, password);
			
			// Preparation de l'objet qui gère la requête:
			PreparedStatement statement = connexion.prepareStatement("SELECT * FROM Produits WHERE id=?");
			statement.setInt(1,id);
			rs = statement.executeQuery();
		
			if (rs.next()) {
				int idProduit = rs.getInt("id");
				String nomProduit = rs.getString("nom");
				double prixUnitaire = rs.getDouble("prix");
				int quantiteProduit = rs.getInt("quantite");
				/*boolean lot = rs.getBoolean("lot"); 
				String commentaire;
				boolean enVente;*/
				
				// On recupère l'id du fournisseur:
				int idFournisseur = rs.getInt("fournisseur");
				
				// On recupère le fournisseur en base de données:
				Fournisseur fournisseur = this.findFournisseurById(idFournisseur);
				
				produit = new Produit(idProduit, nomProduit, prixUnitaire, quantiteProduit, fournisseur);
				
			}
			
			return produit;
			
		} finally {
			if (connexion != null) connexion.close();
			return produit;
		}		
	} // Fin finById.
	
	
	// Methode de rechercher un produit par son nom:
	@SuppressWarnings("finally")
	public Produit findByName(String nom) throws Exception {
		
		Produit produit = null;
		Connection connexion = null;
		ResultSet rs;
		try {
			// driver MySQL
			Class.forName(NOM_DRIVER); 
			// Connexion à la base de données:
			connexion = DriverManager.getConnection(url, user, password);
			
			// Preparation de l'objet qui gère la requête:
			PreparedStatement statement = connexion.prepareStatement("SELECT * FROM Produits WHERE nom=?");
			statement.setString(1,nom);
			rs = statement.executeQuery();
			
			if (rs.next()) {
				int idProduit = rs.getInt("id");
				String nomProduit = rs.getString("nom");
				double prixUnitaire = rs.getDouble("prix");
				int quantiteProduit = rs.getInt("quantite");
				/*boolean lot = rs.getBoolean("lot"); 
				String commentaire;
				boolean enVente;*/
				
				// On recupère l'id du fournisseur:
				int idFournisseur = rs.getInt("fournisseur");
				
				// On recupère le fournisseur en base de données:
				Fournisseur fournisseur = this.findFournisseurById(idFournisseur);
				
				if (!nomProduit.equalsIgnoreCase("") || nomProduit != null) {
					produit = new Produit(idProduit, nomProduit, prixUnitaire, quantiteProduit, fournisseur);
				}
			}
			return produit;
		
		} finally {
			if (connexion != null) connexion.close();
			return produit;
		}	
	} // Fin findByName

	
	@SuppressWarnings("finally")
	@Override
	public Collection<Produit> findByProvider(Fournisseur fournisseur) throws Exception {
		
		Collection<Produit> produits = null;
		//Collection<Produit> produits = new Collection<>();
		
		/* On prepare la connexion à la base de données */
		Connection connexion = null;
		ResultSet rs;
		
		try {
			// driver MySQL
			Class.forName(NOM_DRIVER); 
			// Connexion à la base de données:
			connexion = DriverManager.getConnection(url, user, password);
			
			// Preparation de l'objet qui gère la requête:
			PreparedStatement statement = connexion.prepareStatement("SELECT * FROM Produits WHERE fournisseur=?");
			statement.setInt(1,fournisseur.getId());
			/* Le resultat de la requête en base de données */
			rs = statement.executeQuery();
			
			/* initialisation du resultats */
			produits = new ArrayList<>();
			Produit produit;
			
			/* Recuperation des resultats dans le resultat de la requête */
			while (rs.next()) {
				int id = rs.getInt("id");
				String nom = rs.getString("nom");
				double prix = rs.getDouble("prix");
				int quantite = rs.getInt("quantite");
				boolean lot = rs.getBoolean("lot");
				double prixLot = rs.getDouble("prixLot");
				boolean enVente = rs.getBoolean("enVente");
				String commentaire = rs.getString("commentaire");
				
				/* Un produit à mettre dans la liste des produits */
				produit = new Produit(id, nom, prix, quantite, lot, prixLot, fournisseur, commentaire, enVente);
				produits.add(produit);
			}
			return produits;
			
		} finally {
			if (connexion != null) connexion.close();
			return produits;
		}
		
	} // Fin finByProvider.

	
	@SuppressWarnings("finally")
	@Override
	public Collection<Produit> findAll() throws SQLException {
		
		Collection<Produit> produits = null;
		//Collection<Produit> produits = new Collection<>();
		
		/* On prepare la connexion à la base de données */
		Connection connexion = null;
		ResultSet rs;		
		try {
			// driver MySQL
			Class.forName(NOM_DRIVER); 
			// Connexion à la base de données:
			connexion = DriverManager.getConnection(url, user, password);
			
			/* Preparation de l'objet qui gère la requête: */ 
			PreparedStatement statement = connexion.prepareStatement("SELECT * FROM Produits ORDER BY id");
			/* Le resultat de la requête en base de données */
			rs = statement.executeQuery();
			
			/* initialisation du resultats */
			produits = new ArrayList<>();
			Produit produit;
			
			/* Recuperation des resultats dans le resultat de la requête */
			while (rs.next()) {
				int id = rs.getInt("id");
				String nom = rs.getString("nom");
				double prix = rs.getDouble("prix");
				int quantite = rs.getInt("quantite");
				boolean lot = rs.getBoolean("lot");
				double prixLot = rs.getDouble("prixLot");
				boolean enVente = rs.getBoolean("enVente");
				String commentaire = rs.getString("commentaire");
				
				/* Recuperation du fournisseur correspondant */
				int idFournisseur = rs.getInt("fournisseur");
				Fournisseur fournisseur = this.findFournisseurById(idFournisseur);
				
				/* Un produit à mettre dans la liste des produits */
				produit = new Produit(id, nom, prix, quantite, lot, prixLot, fournisseur, commentaire, enVente);
				produits.add(produit);
			} // fin while
			
			return produits;
			
		} finally {
			if (connexion != null) connexion.close();
			return produits;
		}

	} // Fin methode findAll.

	
	@SuppressWarnings("finally")
	public Collection<Fournisseur> findAllFournisseurs() throws SQLException {
		Collection<Fournisseur> fournisseurs = new ArrayList<>();
		
		/* On prepare la connexion à la base de données */
		Connection connexion = null;
		ResultSet rs;		
		try {
			// driver MySQL
			Class.forName(NOM_DRIVER); 
			// Connexion à la base de données:
			connexion = DriverManager.getConnection(url, user, password);
			
			/* Preparation de l'objet qui gère la requête: */ 
			PreparedStatement statement = connexion.prepareStatement("SELECT * FROM Fournisseurs ORDER BY id");
			/* Le resultat de la requête en base de données */
			rs = statement.executeQuery();
			
			/* initialisation du resultats */
			//fournisseurs = new ArrayList<>();
			Fournisseur fournisseur;
			
			/* Recuperation des resultats dans le resultat de la requête */
			while (rs.next()) {
				int id = rs.getInt("id");
				String nom = rs.getString("nom");
				String adresse = rs.getString("adresse");
				String telephone = rs.getString("telephone");
				String email = rs.getString("email");
								
				/* Un fournisseur à mettre dans la liste des fournisseurs */
				fournisseur = new Fournisseur(id, nom, adresse, telephone, email);
				fournisseurs.add(fournisseur);
			} // fin while
			
			return fournisseurs;
			
		} finally {
			if (connexion != null) connexion.close();
			return fournisseurs;
		}

	} // Fin methode findAllFournisseurs.
	
	
	@Override
	public void create(Produit produit) throws DAOException, SQLException {
		
		/* Creation du fournisseur s'il n'existe pas: */
		Fournisseur four, fournisseur;
		fournisseur = produit.getProprietaire();
		try {
			/* Création du fournisseur, s'il existe bien sûre !! */
			this.createFournisseur(fournisseur);
			four = this.findFournisseur(fournisseur);
			
			Class.forName(NOM_DRIVER); 
			Connection connexion = null;
			
			/* Connexion à la base de données: */
			connexion = DriverManager.getConnection(url, user, password);
			
			/* Preparation de l'objet qui gère la requête: */
			PreparedStatement statement;
			statement = connexion.prepareStatement("INSERT INTO Produits (nom, prix, quantite, fournisseur, lot, prixLot, enVente, commentaire) VALUES (?,?,?,?,?,?,?,?)");
			statement.setString(1,produit.getNomProduit());
			statement.setDouble(2,produit.getPrixUnitaire());
			statement.setInt(3,produit.getQuantiteProduit());
			statement.setInt(4,four.getId());
			statement.setBoolean(5,produit.isLot());
			statement.setDouble(6,produit.getPrixLot());
			statement.setBoolean(7,produit.isEnVente());
			statement.setString(8,produit.getCommentaire());
			
			/* La création du fournisseur en base de données */
			statement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} // Fin Methode create.
	
	
	public void createFournisseur(Fournisseur fournisseur) throws SQLException, Exception {
		
		/* Verification si le fournisseur existe dans la base de données */
		boolean existe = existeFournisseur(fournisseur);
		/* On ne crée le fournisseur que s'il n'existe pas en base de données: */
		if (existe == false) {
			// driver MySQL
			Class.forName(NOM_DRIVER); 
			Connection connexion = null;
			try {
				/* Connexion à la base de données: */
				connexion = DriverManager.getConnection(url, user, password);
				/* Preparation de l'objet qui gère la requête: */
				PreparedStatement statement;
				statement = connexion.prepareStatement("INSERT INTO Fournisseurs (nom, adresse, telephone, email) VALUES (?,?,?,?)");
				statement.setString(1,fournisseur.getNom());
				statement.setString(2,fournisseur.getAdresse());
				statement.setString(3,fournisseur.getTelephone());
				statement.setString(4,fournisseur.getEmail());
				
				/* La création du fournisseur en base de données */
				statement.executeUpdate();
			} finally {
				if (connexion != null) connexion.close();
			}							
		}
	
	} // Fin methode createFournisseur.
	

	@Override
	public void delete(Produit produit) throws DAOException, Exception {
		Connection connexion = null;
		try {
			/* driver MySQL */
			Class.forName(NOM_DRIVER);
			/* Connexion à la base de données: */
			connexion = DriverManager.getConnection(url, user, password);
			/* Preparation de l'objet qui gère la requête: */
			PreparedStatement statement;
			statement = connexion.prepareStatement("DELETE FROM Produits WHERE id=?");
			statement.setInt(1,produit.getId());
						
			/* Le suppression du produit en base de données */
			statement.executeUpdate();
		} finally {
			if (connexion != null) connexion.close();
		}							
	} // Fin methode delete.

	
	public void deleteFournisseur(Fournisseur fournisseur) throws DAOException, Exception {
		Connection connexion = null;
		Collection<Produit> produits;
		try {
			/* driver MySQL */
			Class.forName(NOM_DRIVER);
			/* Connexion à la base de données: */
			connexion = DriverManager.getConnection(url, user, password);
			/* Preparation de l'objet qui gère la requête: */
			PreparedStatement statement;
			statement = connexion.prepareStatement("DELETE FROM Fournisseurs WHERE id=?");
			statement.setInt(1,fournisseur.getId());
			
			/* On verifie si le fournisseur n'a pas de produit existant: */
			produits = this.findByProvider(fournisseur);
			if ((produits == null) || (produits.size() < 1)) {
				/* Le suppression du produit en base de données */
				statement.executeUpdate();
			}
		} finally {
			if (connexion != null) connexion.close();
		}							
	} // Fin methode deleteFournisseur.
	
	
	@Override
	public void update(Produit prod) throws Exception {
		Connection connexion = null;
		try {
			/* driver MySQL */
			Class.forName(NOM_DRIVER);
			/* Connexion à la base de données: */
			connexion = DriverManager.getConnection(url, user, password);
			/* Preparation de l'objet qui gère la requête: */
			PreparedStatement statement;
			
			/* On recherche le produit en base de données: */
			int id = prod.getId();
			Produit produit = this.findById(id);
			
			/* Si le produit existe, le mettre à jour: */
			if ((produit != null) && (!produit.getNomProduit().equals(""))){
				/* La requête pour le update: */
				statement = connexion.prepareStatement("UPDATE Produits SET nom=?, prix=?, quantite=?, fournisseur=?, lot=?, prixLot=?, enVente=?, commentaire=? WHERE id=?");
				
				/* Les champs/valeurs utils pour la mise à jour du produit: */
				statement.setString(1, prod.getNomProduit());
				statement.setDouble(2, prod.getPrixUnitaire());
				statement.setInt(3, prod.getQuantiteProduit());
				int idFournisseur = prod.getProprietaire().getId();
				statement.setInt(4, idFournisseur);
				statement.setBoolean(5, prod.isLot());
				statement.setBoolean(6, prod.isEnVente());
				statement.setString(7, prod.getCommentaire());
				statement.setInt(8, prod.getId());
				
				/* Execution de la requête de la mise à jour du produit: */
				statement.executeUpdate();
			}
		} finally {
			if (connexion != null) connexion.close();
		}					

	} /* Fin methode update. */

	
	// Methode pour mettre en vente un produit qui existe en base de données:
	public void miseEnVente (Produit produit) throws Exception {
		Connection connexion = null;
		try {
			/* driver MySQL */
			Class.forName(NOM_DRIVER);
			/* Connexion à la base de données: */
			connexion = DriverManager.getConnection(url, user, password);
			/* Preparation de l'objet qui gère la requête: */
			PreparedStatement statement;
			
			/* On recherche le produit en base de données: */
			int id = produit.getId();
			
			/* La requête pour le update: */
			statement = connexion.prepareStatement("UPDATE Produits SET enVente=? WHERE id=?");
			statement.setString(1, "true");	
			statement.setInt(2, id);
			
			/* Execution de la requête de la mise à jour du produit: */
			statement.executeUpdate();
			
		} finally {
			if (connexion != null) connexion.close();
		}	
		
	}
	
	
	/*
	@Override
	public void update(Produit produit) throws DAOException {
		// TODO Auto-generated method stub

	} 

	
	@Override
	public Collection<Produit> findAllByProvider(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return null;
	}   */

}
