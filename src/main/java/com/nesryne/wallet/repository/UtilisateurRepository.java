package com.nesryne.wallet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nesryne.wallet.entities.Utilisateur;


public interface UtilisateurRepository  extends JpaRepository<Utilisateur, Long> {
    Optional<Utilisateur> findByNom(String nom);
    Boolean existsByNom(String nom);

    Boolean existsByEmail(String email);
    
    
}

