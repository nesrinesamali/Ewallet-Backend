package com.ewallet.wallet.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name="Revenu")
public class Revenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRevenu")
    private Long idRevenu;
    @Column(name = "montant")
    private Double montant;
    @Column(name="date")
    private Date date;
    @Column(name = "source")
    private String source;

   @ManyToOne
@JoinColumn(name = "user_id")
private Utilisateur utilisateur;
    
}
    
    
    