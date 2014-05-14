package fr.demos.formation.sigdv.model;

public class Etiquette {
	
	// Les attributes de la classe:
	private int idProduit;
	private int idFournisseur;
	private double prixProduit;
	
	/* Les differents constructeurs */
	public Etiquette (int idProduit, int idFournisseur, double prixProduit) {
		this.idProduit = idProduit;
		this.idFournisseur = idFournisseur;
		this.prixProduit = prixProduit;
	}
	
	/* Constructeur en paramètre un "Produit" */
	public Etiquette (Produit produit) {
		this.idProduit = produit.getId();
		this.idFournisseur = produit.getProprietaire().getId();
		this.prixProduit = produit.getPrixUnitaire();
	}

	/* Les getters et les setters */
	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public int getIdFournisseur() {
		return idFournisseur;
	}

	public void setIdFournisseur(int idFournisseur) {
		this.idFournisseur = idFournisseur;
	}

	public double getPrixProduit() {
		return prixProduit;
	}

	public void setPrixProduit(double prixProduit) {
		this.prixProduit = prixProduit;
	}

	/* Methode pour afficher une etiquette */
	@Override
	public String toString() {
		return "Etiquette [idProduit=" + idProduit + ", idFournisseur="
				+ idFournisseur + ", prixProduit=" + prixProduit + "]";
	}

	/* Les methodes hashcode et equals */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idFournisseur;
		result = prime * result + idProduit;
		long temp;
		temp = Double.doubleToLongBits(prixProduit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Etiquette other = (Etiquette) obj;
		if (idFournisseur != other.idFournisseur)
			return false;
		if (idProduit != other.idProduit)
			return false;
		if (Double.doubleToLongBits(prixProduit) != Double
				.doubleToLongBits(other.prixProduit))
			return false;
		return true;
	}
	
}
