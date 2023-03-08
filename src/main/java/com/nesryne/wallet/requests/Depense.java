package com.nesryne.wallet.requests;

import java.util.Date;

public class Depense {
	private Date date;
	private float montantDepense;
	private String description;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public float getMontantDepense() {
		return montantDepense;
	}
	public void setMontantDepense(float montantDepense) {
		this.montantDepense = montantDepense;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Depense() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
