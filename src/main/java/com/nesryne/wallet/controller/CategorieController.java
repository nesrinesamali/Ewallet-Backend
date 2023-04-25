package com.nesryne.wallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
// import org.springframework.web.bind.annotation.RequestMapping;

import com.nesryne.wallet.entities.Categorie;
import com.nesryne.wallet.service.CategorieService;
import com.nesryne.wallet.service.dto.CategorieDto;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CategorieController {
    @Autowired
    private CategorieService categorieService;


    @PostMapping("/saveCategorie")
    @ResponseBody
    public CategorieDto saveCategories( @RequestBody CategorieDto categorieDto)
    {
        return categorieService.saveCategories(categorieDto);
    }
    
    @GetMapping("/categories")
 
 
    public List<CategorieDto> getAllCategories() {
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
    @GetMapping("/maCategorie")
    @ResponseBody
 
    public Categorie getCategories(@PathVariable("id") Long idCategorie) {
        return categorieService.getCategories(idCategorie);

        
        
        
}
}


