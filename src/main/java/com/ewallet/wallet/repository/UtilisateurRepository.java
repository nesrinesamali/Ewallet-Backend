package com.ewallet.wallet.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ewallet.wallet.entities.Utilisateur;


public interface UtilisateurRepository  extends JpaRepository<Utilisateur, Long> {
    Optional<Utilisateur> findByNom(String nom);
    Boolean existsByNom(String nom);
    Boolean existsByEmail(String email);

    Optional<Utilisateur> findByEmail(String email);
    List<Utilisateur> findAllByRole(String role);

    @Query(value = "SELECT COALESCE((SELECT SUM(montant) FROM revenu where user_id=?1), 0) -  COALESCE((SELECT SUM(montant) FROM depense where user_id=?1), 0)AS soldeDeCompte", nativeQuery = true)
    Double getSoldeDeCompte(Long idUser);}

