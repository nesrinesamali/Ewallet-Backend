package com.nesryne.wallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nesryne.wallet.entities.Categorie;
import com.nesryne.wallet.service.CategorieService;
import com.nesryne.wallet.service.dto.CategorieDto;

// @CrossOrigin(origins = "http://localhost:4200/",maxAge = 3600)
@RestController
// @RequestMapping(value = "/categories")
public class CategorieController {
    @Autowired
    private CategorieService categorieService;


    @PostMapping("/SaveCategorie")
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


