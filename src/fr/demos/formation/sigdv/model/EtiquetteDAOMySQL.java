package fr.demos.formation.sigdv.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

public class EtiquetteDAOMySQL implements EtiquetteDAO {
	
	private static final String NOM_DRIVER="com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/sigdv";
	private static final String user = "root";
	private static final String password = "manager";
	
	private DataSource ds;
	

	@Override
	public Collection<Etiquette> creerEtiquette() throws DAOException,
			Exception {
		/* Initialisation des données */
		List<Etiquette> etiquettes = null;
		Etiquette etiquette;
		Connection connexion = null;
		ResultSet rs;
		
		try {
			// driver MySQL
			Class.forName(NOM_DRIVER); 
			// Connexion à la base de données:
			connexion = DriverManager.getConnection(url, user, password);
	
			// Preparation de l'objet qui gère la requête:
			PreparedStatement statement = connexion.prepareStatement("SELECT * FROM produits WERE enVente=?");
			statement.setString(1,"true");
			rs = statement.executeQuery();
			
			// Verification si le resultat n'est pas vide:
			while (rs.next()) {
				int id = rs.getInt("id");
				int idFournisseur = rs.getInt("fournisseur");
				double prix = rs.getDouble("prix");
				
				/* Construction d'une etiquette pour un produit donné en vente */
				etiquette = new Etiquette(id, idFournisseur, prix);
				
				/* Ajouter l'etiquette dans la liste des étiquettes */
				etiquettes.add(etiquette);
			}	
			return etiquettes;
		} finally {
			if (connexion != null) connexion.close();
			return etiquettes;
		} // Fin Try.
	} // Fin creerEtiquettes.

	
	@Override
	public Collection<Etiquette> creerEtiquette(Collection<Produit> produits)
			throws DAOException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
