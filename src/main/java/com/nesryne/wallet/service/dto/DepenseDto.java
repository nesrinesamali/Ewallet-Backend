package com.nesryne.wallet.service.dto;

import java.util.Date;

import lombok.Data;
@Data
public class DepenseDto {
    private Long idDepense;
    private Date date;
    private Double montant;
    private String Description;
    private Long userId;
    private Long categorieId;
    
}
