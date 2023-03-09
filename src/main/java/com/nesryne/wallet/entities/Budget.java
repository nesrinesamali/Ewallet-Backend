package com.nesryne.wallet.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name="Budget")
public class Budget {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idBudget;
	@Column(name="montant")
	private Double montantbuget;
	@Column(name="Date")
	private Date date;
	
	public Budget() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Budget(Double montant, Date date) {
		super();
		this.montantbuget = montant;
		this.date = date;
	}
	@Override
	public String toString() {
		return "Budget [idBudget=" + idBudget + ", montant=" + montantbuget + ", date=" + date + "]";
	}

	public Long getIdBudget() {
		return idBudget;
	}
	public void setIdBudget(Long idBudget) {
		this.idBudget = idBudget;
	}
	public Double getMontant() {
		return montantbuget;
	}
	public void setMontant(Double montant) {
		this.montantbuget = montant;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	

}
