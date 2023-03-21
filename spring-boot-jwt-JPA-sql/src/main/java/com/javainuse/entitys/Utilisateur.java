package com.javainuse.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Utilisateur")
public class Utilisateur {
    private Long idUtilisateur;
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse; 
    private String Role;
    private Double soldeDeCompte;
 


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
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
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
    public String getRole() {
        return Role;
    }
    public void setRole(String role) {
        Role = role;
    }
    public Double getSoldeDeCompte() {
        return soldeDeCompte;
    }
    public void setSoldeDeCompte(Double soldeDeCompte) {
        this.soldeDeCompte = soldeDeCompte;
    }
    
public Utilisateur(Long idUtilisateur, String nom, String prenom, String email, String motDePasse, String role,
            Double soldeDeCompte) {
        this.idUtilisateur = idUtilisateur;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        Role = role;
        this.soldeDeCompte = soldeDeCompte;
    }

 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 public long getId() {
 return id;
 }
 public void setId(long id) {
 this.id = id;
 }
 @Column(name = "first_name", nullable = false)
 public String getFirstName() {
 return firstName;
 }
 public void setFirstName(String firstName) {
 this.firstName = firstName;
 }
 @Column(name = "last_name", nullable = false)
 public String getLastName() {
 return lastName;
 }
 public void setLastName(String lastName) {
 this.lastName = lastName;
 }

 @Column(name = "email_address", nullable = false)
 public String getEmailId() {
 return emailId;
 }
 public void setEmailId(String emailId) {
 this.emailId = emailId;
 }
@Override
public String toString() {
    return "Utilisateur [idUtilisateur=" + idUtilisateur + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email
            + ", motDePasse=" + motDePasse + ", Role=" + Role + ", soldeDeCompte=" + soldeDeCompte + "]";
}

}

