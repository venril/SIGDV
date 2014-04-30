package fr.demos.formation.sigdv.model;


public class Fournisseur {
	
	private static int idFournisseur = 0;
	
	// Les attibuts
	private int id;
	private String nom;
	private String adresse;
	private String telephone;
	private String email;
	
	// Les Constructeurs:
	public Fournisseur(String nom, String adresse,
			String telephone, String email) {
		this.idFournisseur++;
		this.id = this.idFournisseur;
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
	}	
	
	// Les Constructeurs:
	public Fournisseur(int id, String nom, String adresse,
			String telephone, String email) {
		this.idFournisseur++;
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
	}
	
	public Fournisseur(int id, String nom) {
		this.idFournisseur++;
		this.id = id;		
		this.nom = nom;
		this.adresse = "";
		this.email = "";
		this.telephone = "";
	}
	
	public Fournisseur(String nom) {
		this.idFournisseur++;
		this.id = this.idFournisseur;
		this.nom = nom;
		this.adresse = "";
		this.email = "";
		this.telephone = "";
	}
	
	// Methode equals and hashcode:
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result
				+ ((telephone == null) ? 0 : telephone.hashCode());
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
		Fournisseur other = (Fournisseur) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		return true;
	}

	// Les getters et les Setters
	public int getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Fournisseur [id=" + this.id + ", nom=" + nom +
				", adresse=" + adresse + ", telephone=" + telephone
				+ ", email=" + email + "]";
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return this.nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return this.adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return this.telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
