package com.nesryne.wallet.payload.Response;



public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long idUtilisateur ;
    private String nom;
    private String email;


    public JwtResponse(String accessToken, Long idUtilisateur, String nom, String email ) {
        this.token = accessToken;
        this.idUtilisateur = idUtilisateur;
        this.nom = nom;
        this.email = email;
     
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   
}
