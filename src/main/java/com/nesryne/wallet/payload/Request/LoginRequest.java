package com.nesryne.wallet.payload.Request;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank
    private String nom;

    @NotBlank
    private String motDePasse;


    public LoginRequest(){}
   
    
    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }


    public String getNom() {
      return nom;
    }


    public void setNom(String nom) {
      this.nom = nom;
    }


}