package com.nesryne.wallet.service.dto;

import java.util.Date;

import lombok.Data;
@Data
public class CategoriesDto {
    private Long idCategorie;
	private String description;
	private String typeCategorie;
    private Date date;
	
}
