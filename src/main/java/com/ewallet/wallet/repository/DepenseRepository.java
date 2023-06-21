package com.ewallet.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

import com.ewallet.wallet.entities.Depense;

// @Repository
public interface DepenseRepository extends JpaRepository<Depense,Long>{
    
}
