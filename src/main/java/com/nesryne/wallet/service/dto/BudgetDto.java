package com.nesryne.wallet.service.dto;

import java.util.Date;

import lombok.Data;
@Data
public class BudgetDto {
    private Long idBudget;
    private Double montantbuget;
    private Date date;
}
