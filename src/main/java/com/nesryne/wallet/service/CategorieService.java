package com.nesryne.wallet.service;

import java.util.List;

import com.nesryne.wallet.entities.Categorie;
import com.nesryne.wallet.service.dto.CategorieDto;

public interface CategorieService {
   
    
        CategorieDto  saveCategories(CategorieDto categorieDto);
        CategorieDto  updateCategories(CategorieDto categorieDto);
        void deleteCategoriesById(Long idCategorie);
        Categorie getCategories(Long idCategorie);
        List<CategorieDto > getAllCategories();
        
        
}
