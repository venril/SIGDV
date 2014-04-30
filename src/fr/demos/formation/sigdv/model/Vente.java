package fr.demos.formation.sigdv.model;

import fr.demos.formation.sigdv.model.Fournisseur;
import fr.demos.formation.sigdv.model.Produit;
import fr.demos.formation.sigdv.model.Vente;

public class Vente {

	// Les attributs:
	private String id;
	private Produit produit;
	private Fournisseur fournisseur;
	private int quantiteVendu;
	
	// Les constructeurs:
	public Vente(String id, Produit produit, Fournisseur fournisseur,
			int quantiteVendu) {
		super();
		this.id = id;
		this.produit = produit;
		this.fournisseur = fournisseur;
		this.quantiteVendu = quantiteVendu;
	}

	// Les setters et les getters:	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public int getQuantiteVendu() {
		return quantiteVendu;
	}

	public void setQuantiteVendu(int quantiteVendu) {
		this.quantiteVendu = quantiteVendu;
	}

	// La methode toString:
	@Override
	public String toString() {
		return "Vente [id=" + id + ", produit=" + produit + ", fournisseur="
				+ fournisseur + ", quantiteVendu=" + quantiteVendu + "]";
	}

	// Methode hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fournisseur == null) ? 0 : fournisseur.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((produit == null) ? 0 : produit.hashCode());
		result = prime * result + quantiteVendu;
		return result;
	}

	// La methode equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vente other = (Vente) obj;
		if (fournisseur == null) {
			if (other.fournisseur != null)
				return false;
		} else if (!fournisseur.equals(other.fournisseur))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (produit == null) {
			if (other.produit != null)
				return false;
		} else if (!produit.equals(other.produit))
			return false;
		if (quantiteVendu != other.quantiteVendu)
			return false;
		return true;
	}
	
}
