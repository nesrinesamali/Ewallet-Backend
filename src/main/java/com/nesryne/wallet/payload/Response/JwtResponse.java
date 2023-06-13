package com.nesryne.wallet.payload.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long idUtilisateur ;
    private String nom;
   private String role ;
public JwtResponse(String token, Long idUtilisateur, String nom, String role) {
    this.token = token;
    this.idUtilisateur = idUtilisateur;
    this.nom = nom;
    this.role = role;
}


    

   
}
