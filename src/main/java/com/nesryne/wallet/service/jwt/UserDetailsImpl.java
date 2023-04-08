package com.nesryne.wallet.service.jwt;


import java.util.Collection;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.nesryne.wallet.entities.Utilisateur;

public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Long idUtilisateur;

    private String nom;

    private String email;

    @JsonIgnore
    private String motDePasse;

    
	private Collection<? extends GrantedAuthority> authorities;
    
    public UserDetailsImpl(Long idUtilisateur, String nom, String email, String motDePasse 
                       
     ){ this.idUtilisateur= idUtilisateur;
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse ;
        
    }

    public static UserDetailsImpl build(Utilisateur utilisateur) {
      
        return new UserDetailsImpl(
                utilisateur.getIdUtilisateur(),
                utilisateur.getNom(),
                utilisateur.getEmail(),
                utilisateur.getMotDePasse()
                );
                
    }

   

    
    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public String getEmail() {
        return email;
    }
    @Override
    public String getPassword() {
        return motDePasse;
    }
    @Override
	public String getUsername() {
		return nom ;
	}
    @Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl utilisateur = (UserDetailsImpl) o;
        return Objects.equals(idUtilisateur, utilisateur.idUtilisateur);
    }

    

  


    

  
 
}