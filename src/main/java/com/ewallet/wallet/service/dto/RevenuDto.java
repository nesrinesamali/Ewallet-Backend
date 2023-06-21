package com.ewallet.wallet.service.dto;

import java.util.Date;

import lombok.Data;

@Data
public class RevenuDto {

    private Long idRevenu;
    private Double montant;
    private Date date;
    private String source;
}
