package com.nesryne.wallet.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table (name="Categories")
public class Categories {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCategorie;
	@Column(name="description")
	private String description;
	@Column(name="typeCategorie")
	private String typeCategorie;
	@Column(name="date")
	private Date date;

	@OneToMany(mappedBy = "categories")
    private List<Depenses> depenses;

	public Categories(Long idCategorie, String description, String typeCategorie, Date date) {
		this.idCategorie = idCategorie;
		this.description = description;
		this.typeCategorie = typeCategorie;
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Categories [idCategorie=" + idCategorie + ", description=" + description + ", typeCategorie="
				+ typeCategorie + ", date=" + date + "]";
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
	public String getTypeCategorie() {
		return typeCategorie;
	}
	public void setTypeCategorie(String typeCategorie) {
		this.typeCategorie = typeCategorie;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
