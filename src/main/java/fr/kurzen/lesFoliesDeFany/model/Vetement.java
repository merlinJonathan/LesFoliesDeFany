package fr.kurzen.lesFoliesDeFany.model;

import javax.persistence.*;

@Entity
public class Vetement {

	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String nom;
	
	@Column
	private String couleur;
	
	@Column
	private String taille;
	
	@Column
	private String description;
	
	@Column
	private String prix;
	
	@Column 
	private String photos;
	
	@Column
	private String nbEnStock;

	public Vetement(String nom, String couleur, String taille, String description, String prix, String photos,
			String nbEnStock) {
		super();
		this.nom = nom;
		this.couleur = couleur;
		this.taille = taille;
		this.description = description;
		this.prix = prix;
		this.photos = photos;
		this.nbEnStock = nbEnStock;
	}

	public Vetement() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getTaille() {
		return taille;
	}

	public void setTaille(String taille) {
		this.taille = taille;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	@Override
	public String toString() {
		return "Vetement [id=" + id + ", nom=" + nom + ", couleur=" + couleur + ", taille=" + taille + ", description="
				+ description + ", prix=" + prix + ", photos=" + photos + "]";
	}
}
