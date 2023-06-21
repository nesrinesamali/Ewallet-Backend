package com.ewallet.wallet.service.dto;

import java.util.Date;

import lombok.Data;
@Data
public class CategorieDto {
    private Long idCategorie;
	private String description;
	private String typeCategorie;
    private Date date;
	
}
