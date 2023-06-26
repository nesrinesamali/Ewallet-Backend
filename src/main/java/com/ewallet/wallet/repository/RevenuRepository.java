package com.ewallet.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.ewallet.wallet.entities.Revenu;

// @Repository
public interface RevenuRepository extends JpaRepository<Revenu, Long>{
    
    @Query(value = "SELECT SUM(montant) FROM revenu", nativeQuery = true)
    Double getTotalRevenuAmount();
     
}
