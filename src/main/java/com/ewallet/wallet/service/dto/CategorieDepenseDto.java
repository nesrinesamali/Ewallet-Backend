package com.ewallet.wallet.service.dto;



import lombok.Data;

@Data
public class CategorieDepenseDto {
    
    private String nom ;
    private Double sommeMontant ;

    public CategorieDepenseDto(String nom, Double sommeMontant) {
        this.nom = nom;
        this.sommeMontant = sommeMontant;
    }
}
