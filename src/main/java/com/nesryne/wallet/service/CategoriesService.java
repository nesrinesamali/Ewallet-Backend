package com.nesryne.wallet.service;

import java.util.List;

import com.nesryne.wallet.entities.Categories;
import com.nesryne.wallet.service.dto.CategoriesDto;

public interface CategoriesService {
   
    
        CategoriesDto  saveCategories(CategoriesDto categoriesDto);
        CategoriesDto  updateCategories(CategoriesDto categoriesDto);
        void deleteCategoriesById(Long idCategorie);
        Categories getCategories(Long idCategorie);
        List<Categories > getAllCategories();
        
        
}
