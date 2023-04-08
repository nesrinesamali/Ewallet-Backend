package com.nesryne.wallet.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name="Depenses")
public class Depense {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long idDepense;
	@Column(name="date")
private Date date;
	@Column(name="montant")
private Double montant;
	@Column(name="Description")
private String description;

public Depense() {
	super();
	// TODO Auto-generated constructor stub
}

public Depense(Date date, Double montant, String description) {
	super();
	this.date = date;
	this.montant = montant;
	this.description = description;
}

public Long getIdDepense() {
	return idDepense;
}
public void setIdDepense(Long idDepense) {
	this.idDepense = idDepense;
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
	return "Depense [idDepense=" + idDepense + ", date=" + date + ", montant=" + montant + ", description="
			+ description + "]";
}

}
