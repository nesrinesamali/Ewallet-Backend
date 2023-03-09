package com.nesryne.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nesryne.wallet.entities.Budget;

public interface BudgetRepository extends JpaRepository<Budget,Long>{
    
}
