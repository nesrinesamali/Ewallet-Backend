package com.ewallet.wallet.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table (name="Categorie")
public class Categorie {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCategorie;
	
	@Column(name="description")
	private String description;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="budget")
	private Double budget;

	private Long creatorId;



	public Categorie(Long idCategorie, String description, String nom, Double budget ) {
		this.idCategorie = idCategorie;
		this.description = description;
		this.nom = nom;
		this.budget = budget;
	}

	public Categorie() {
		super();
	}

	@Override
	public String toString() {
		return "Categorie [idCategorie=" + idCategorie + ", description=" + description + ", nom="
		+ nom + ", budget=" + budget + "]";
	}

	public Long getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Number getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}
	


	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	


	
	

}