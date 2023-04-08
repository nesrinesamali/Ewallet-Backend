package com.nesryne.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nesryne.wallet.entities.Categorie;

// @Repository
public interface CategorieRepository extends JpaRepository<Categorie,Long>{
    
}
