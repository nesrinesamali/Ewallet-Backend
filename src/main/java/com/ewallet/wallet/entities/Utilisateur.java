package com.ewallet.wallet.entities;



import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
// import lombok.Data;

// @Data
@Entity
@Table (name="Utilisateur")
public class Utilisateur implements UserDetails{

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

    

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id", nullable = false)
    private List<Revenu> revenus;

	public Utilisateur() {
		super();
	
		
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


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       
        return Collections.singleton(new SimpleGrantedAuthority(this.role));
    }
   
    public List<String> getAuthoritiesAsStrings() {
        return getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
      
        return motDePasse;
    }


    @Override
    public String getUsername() {
     
        return email ;
    }


    @Override
    public boolean isAccountNonExpired() {
      
        return true ;
    }


    @Override
    public boolean isAccountNonLocked() {
       
        return true ;
    }


    @Override
    public boolean isCredentialsNonExpired() {
       
        return true ;
    }


    @Override
    public boolean isEnabled() {
     
        return true ;
    }
    


    public List<Revenu> getRevenus() {
        return revenus;
    }


    public void setRevenus(List<Revenu> revenus) {
        this.revenus = revenus;
    }
    
    
   
}

