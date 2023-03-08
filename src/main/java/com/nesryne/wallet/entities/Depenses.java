package com.nesryne.wallet.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table (name="Depenses")
public class Depenses {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long idDepenses;
	@Column(name="date")
private Date date;
	@Column(name="montant")
private Double montant;
	@Column(name="Description")
private String description;

public Depenses() {
	super();
	// TODO Auto-generated constructor stub
}

public Depenses(Date date, Double montant, String description) {
	super();
	this.date = date;
	this.montant = montant;
	this.description = description;
}

public Long getIdDepenses() {
	return idDepenses;
}
public void setIdDepenses(Long idDepenses) {
	this.idDepenses = idDepenses;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public Double getMontant() {
	return montant;
}
public void setMontant(Double montant) {
	this.montant = montant;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

@Override
public String toString() {
	return "Depenses [idDepenses=" + idDepenses + ", date=" + date + ", montant=" + montant + ", description="
			+ description + "]";
}

}
