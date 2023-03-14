package com.nesryne.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nesryne.wallet.entities.Utilisateur;


public interface UtilisateurRepository  extends JpaRepository<Utilisateur, Long> {
    
}

