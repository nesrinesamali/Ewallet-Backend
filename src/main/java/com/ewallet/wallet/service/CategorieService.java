package com.ewallet.wallet.service;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.ewallet.wallet.entities.Categorie;
import com.ewallet.wallet.service.dto.CategorieDepenseDto;
import com.ewallet.wallet.service.dto.CategorieDto;

public interface CategorieService {
   
    
        Categorie  saveCategories(Categorie categorie , Authentication authentication);
        CategorieDto  updateCategories(CategorieDto categorieDto);
        void deleteCategoriesById(Long idCategorie);
        Categorie getCategories(Long idCategorie);
        List<Categorie > getAllCategories(Authentication authentication);
        List <CategorieDepenseDto> listDepenseByCategory();
        List<Object> listBudgetAtteint(Authentication authentication);

        
        
}
