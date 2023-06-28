package com.ewallet.wallet.service.dto;

import java.util.Date;

import com.ewallet.wallet.entities.Depense;

import lombok.Data;
@Data
public class DepenseDto {
    private Long idDepense;
    private Date date;
    private Double montant;
    private String Description;
    private Long userId;
    private Long categorieId;
    private String statut;
    private Date datePrevue; 

    public static Depense toEntity(DepenseDto depenseDto)
    {
        if(depenseDto == null)
        {
            return null ;
        }

        Depense depense = new Depense();
        depense.setIdDepense(depenseDto.getIdDepense() != null ? depenseDto.getIdDepense() : null);
        depense.setDate(depenseDto.getDate());
        depense.setMontant(depenseDto.getMontant());
        depense.setDescription(depenseDto.getDescription());
        depense.setDatePrevue(null);
        return depense ; 
    }

    public static  DepenseDto fromEntity(Depense depense){
        if (depense==null )
        {
            return null;
        }

        DepenseDto depenseDto = new DepenseDto();
        depenseDto.setIdDepense(depense.getIdDepense() != null ? depense.getIdDepense() : null);
        depenseDto.setDate(depense.getDate());
        depenseDto.setMontant(depense.getMontant());
        depenseDto.setDescription(depense.getDescription());
        depenseDto.setDatePrevue(null);
        depenseDto.setUserId(depense.getUtilisateur().getIdUtilisateur());
        depenseDto.setCategorieId(depense.getCategorie().getIdCategorie());
        return depenseDto;
    } 
    
}
