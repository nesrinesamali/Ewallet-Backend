package com.ewallet.wallet.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;


@Entity
@Table (name="Depense")
public class Depense {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long idDepense;

@Column(name="Description")
private String description;

@Column(name="montant")
private Double montant;

@Column(name="date")
private Date date;

@Column(name="datePrevue")
private Date datePrevue;

@Column(name="Statut")
private String statut;

	


public Depense() {
	super();
	// TODO Auto-generated constructor stub
}

public Depense(Date date, Double montant, String description, String statut, Date datePrevue) {
	super();
	this.date = date;
	this.montant = montant;
	this.description = description;
	this.datePrevue = datePrevue;
	this.statut = statut;
}

public Date getDatePrevue() {
	return datePrevue;
}

public void setDatePrevue(Date datePrevue) {
	this.datePrevue = datePrevue;
}

public String getStatut() {
	return statut;
}

public void setStatut(String statut) {
	this.statut = statut;
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
@Override
public String toString() {
	return "Depense [idDepense=" + idDepense + ", description=" + description + ", montant=" + montant + ", date="
			+ date + ", datePrevue=" + datePrevue + ", statut=" + statut + "]";
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



}
