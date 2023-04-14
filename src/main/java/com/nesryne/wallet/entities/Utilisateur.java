package com.nesryne.wallet.entities;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// import lombok.Data;

// @Data
@Entity
@Table (name="Utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUtilisateur")
    private Long idUtilisateur;
    @Column(name = "nom")
    private String nom;
    @Column(name = "renom")
    private String prenom;
    @Column(name = "email")
    private String email;
    @Column(name = "motDePasse")
    private String motDePasse; 
    @Column(name = "role")
    private String role;
    @Column(name = "soldeDeCompte")
    private Double soldeDeCompte;

    @OneToMany
    @JoinColumn(name="user_id")
    private List<Depense> depenses;

    @OneToMany
    @JoinColumn(name="user_id")
    private List<Revenu> revenus;

	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

   
    public Utilisateur(String nom, String email, String motDePasse) {
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
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

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
     public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Double getSoldeDeCompte() {
        return soldeDeCompte;
    }

    public void setSoldeDeCompte(Double soldeDeCompte) {
        this.soldeDeCompte = soldeDeCompte;
    }
    
    
   
}

