package com.nesryne.wallet.payload.Request;


import javax.validation.constraints.*;

public class SignupRequest {
  @NotBlank
  @Size(min = 3, max = 20)
  private String nom;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;


  @NotBlank
  @Size(min = 6, max = 40)
  private String motDePasse;

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getMotDePasse() {
    return motDePasse;
  }

  public void setMotDePasse(String motDePasse) {
    this.motDePasse = motDePasse;
  }

  
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

 
}
