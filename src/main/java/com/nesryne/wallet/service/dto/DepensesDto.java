package com.nesryne.wallet.service.dto;

import java.util.Date;

import lombok.Data;
@Data
public class DepensesDto {
    private Long idDepenses;
    private Date date;
    private Double montant;
    private String Description;
    
}
