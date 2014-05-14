package fr.demos.formation.sigdv.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;
import java.util.List;

public class TestChargerProduit {
	
	public static void main (String[] args) throws Exception {
		/*
		FileReader fic=new FileReader("C:/Users/BEN/Documents/CQP/STAGE2014-01/SWSandro/Docs/FicherProduit.csv");
		BufferedReader br = new BufferedReader (fic);
		String line=null;
		
		while ((line=br.readLine()) != null) System.out.println(line);
		
		br.reset();
		fic.close();
		*/
		ProduitDAOMySQL dao = new ProduitDAOMySQL();
		List<Produit> produits, produits2;
		List<Fournisseur> fournisseurs;
		/*
		//Collection<Produit> produits;
		String fichier = "C:/Users/BEN/Documents/CQP/STAGE2014-01/SWSandro/Docs/FicherProduit.csv";
		produits = (List<Produit>) dao.chargerProduit(fichier); */
		fournisseurs = (List<Fournisseur>) dao.findAllFournisseurs();
		produits2 = (List<Produit>) dao.findAll();
		
		// Afficher la liste des produits:
		for (int i=0; i< produits2.size(); i++) {
			dao.miseEnVente(produits2.get(i));
			System.out.println(produits2.get(i));
		}
		
		System.out.println("***************************************************");
		
		/*
		System.out.println(dao.findById(2));
		System.out.println(dao.findById(4));
		System.out.println(dao.findById(5));
		System.out.println(dao.findById(10));
		System.out.println(dao.findById(15));
		
		// Test de suppression d'un produit:
		Produit prod = produits2.get(6);
		Fournisseur four1, four2;
		four1 = fournisseurs.get(5);
		four2 = fournisseurs.get(1);
		
		System.out.println(four2);
		
		dao.delete(prod);
		dao.deleteFournisseur(four1);
		dao.deleteFournisseur(four2); */
		
	}

}
