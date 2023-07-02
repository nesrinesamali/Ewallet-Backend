package com.ewallet.wallet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.ewallet.wallet.entities.Depense;
import com.ewallet.wallet.entities.Revenu;

// @Repository
public interface RevenuRepository extends JpaRepository<Revenu, Long> {

    @Query(value = "SELECT SUM(montant) FROM revenu where user_id=?", nativeQuery = true)
    Double getTotalRevenuAmount(long idUser);

    @Query(value = "SELECT montant, date FROM revenu", nativeQuery = true)
    List<Object[]> listmontantDateRevenu();


    List<Revenu> findAllByUtilisateurIdUtilisateur(Long id);
}
