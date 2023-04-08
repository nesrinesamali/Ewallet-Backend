package com.nesryne.wallet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nesryne.wallet.entities.Utilisateur;

// @Repository
public interface UtilisateurRepository  extends JpaRepository<Utilisateur, Long> {
    Optional<Utilisateur> findByNom(String nom);
    Boolean existsByNom(String nom);

    Boolean existsByEmail(String email);
    
    
}

