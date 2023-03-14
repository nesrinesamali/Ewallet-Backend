package com.nesryne.wallet.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Revenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRevenu;
    private Double montant;
    private Date date;
    private String source;
    
}
    
    
    