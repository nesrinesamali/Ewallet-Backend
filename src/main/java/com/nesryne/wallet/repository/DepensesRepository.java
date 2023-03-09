package com.nesryne.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nesryne.wallet.entities.Depenses;

public interface DepensesRepository extends JpaRepository<Depenses,Long>{
    
}
