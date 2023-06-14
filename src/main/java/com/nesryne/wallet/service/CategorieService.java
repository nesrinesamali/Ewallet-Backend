package com.nesryne.wallet.service;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.nesryne.wallet.entities.Categorie;
import com.nesryne.wallet.service.dto.CategorieDto;

public interface CategorieService {
   
    
        Categorie  saveCategories(Categorie categorie , Authentication authentication);
        CategorieDto  updateCategories(CategorieDto categorieDto);
        void deleteCategoriesById(Long idCategorie);
        Categorie getCategories(Long idCategorie);
        List<Categorie > getAllCategories();
        
        
}
