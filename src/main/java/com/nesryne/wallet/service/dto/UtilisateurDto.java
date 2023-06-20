package com.nesryne.wallet.service.dto;


import lombok.Data;

@Data
public class UtilisateurDto {
    
    private Long idUtilisateur;
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse; 
    private String Role;
    private Double soldeDeCompte;
    private Double RevenuDuJour;
    private Double DepenseDuJour;

}
