package com.nesryne.wallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nesryne.wallet.entities.Categorie;
import com.nesryne.wallet.service.CategorieService;
import com.nesryne.wallet.service.dto.CategorieDto;


@RestController
public class CategorieController {
    @Autowired
    private CategorieService categorieService;


    @PostMapping("/Categories")
    @ResponseBody
    public CategorieDto saveCategories( @RequestBody CategorieDto categorieDto)
    {
        return categorieService.saveCategories(categorieDto);
    }
    
    @GetMapping("/getCategories")
    @ResponseBody
 
    public List<Categorie> getAllCategories() {
        return categorieService.getAllCategories();
    }
 
    @PutMapping("/updateCategories")
 
    public CategorieDto
    updateCategories(@RequestBody CategorieDto categorieDto)
    {
        return categorieService.updateCategories(categorieDto);
    }
 
    
    @DeleteMapping("/deleteCategories/{id}")
 @ResponseBody
    public void deleteCategoriesById(@PathVariable("id") Long idCategorie)
    {
        categorieService.deleteCategoriesById(idCategorie);
         
        }
    @GetMapping("/moncategorie")
    @ResponseBody
 
    public Categorie getCategories(@PathVariable("id") Long idCategorie) {
        return categorieService.getCategories(idCategorie);

        
        
        
}
}


