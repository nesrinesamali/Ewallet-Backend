package com.nesryne.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nesryne.wallet.entities.Categories;

public interface CategoriesRepository extends JpaRepository<Categories,Long>{
    
}
