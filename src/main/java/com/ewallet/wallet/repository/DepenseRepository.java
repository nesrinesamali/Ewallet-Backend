package com.ewallet.wallet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.ewallet.wallet.entities.Depense;

// @Repository
public interface DepenseRepository extends JpaRepository<Depense,Long>{
    @Query(value = "SELECT * FROM depense ORDER BY date ASC LIMIT 6", nativeQuery = true)
    List<Depense> findLastDepenses();
    @Query(value = "SELECT SUM(montant) FROM depense", nativeQuery = true)
    Double getTotalDepenseAmount();
    @Query(value = "SELECT * FROM depense WHERE statut IS NOT NULL", nativeQuery = true)
    List<Depense> getPaiementsPrevus();

    List<Depense> findAllByUtilisateurIdUtilisateur(Long id);
}

