package com.ewallet.wallet.service.dto;

import java.util.Date;

import com.ewallet.wallet.entities.Revenu;

import lombok.Data;

@Data
public class RevenuDto {

    private Long idRevenu;
    private Double montant;
    private Date date;
    private String source;
    private Long userId;

    public static Revenu toEntity(RevenuDto revenuDto)
    {
        if(revenuDto == null)
        {
            return null ;
        }

        Revenu revenu = new Revenu();
        revenu.setIdRevenu(revenuDto.getIdRevenu() != null ? revenuDto.getIdRevenu() : null);
        revenu.setMontant(revenuDto.getMontant());
        revenu.setSource(revenuDto.getSource());
        revenu.setDate(revenuDto.getDate());
        return revenu ; 
    }

    public static  RevenuDto fromEntity(Revenu revenu){
        if (revenu==null )
        {
            return null;
        }

        RevenuDto revenuDto = new RevenuDto();
        revenuDto.setIdRevenu(revenu.getIdRevenu() != null ? revenu.getIdRevenu() : null);
        revenuDto.setMontant(revenu.getMontant());
        revenuDto.setDate(revenu.getDate());
        
        revenuDto.setSource(revenu.getSource());
        revenuDto.setUserId(revenu.getUtilisateur().getIdUtilisateur());
        return revenuDto;
    } 
}
