package com.nesryne.wallet.controller;

import java.util.List;

import com.nesryne.wallet.service.mapper.CategorieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nesryne.wallet.entities.Categorie;
import com.nesryne.wallet.service.CategorieService;
import com.nesryne.wallet.service.dto.CategorieDto;

@RequestMapping("/categories")
@RestController
public class CategorieController {
    @Autowired
    private CategorieService categorieService;

    @Autowired
    private CategorieMapper categorieMapper;

    public CategorieController(CategorieMapper categorieMapper) {
        this.categorieMapper = categorieMapper;

    }
    @PostMapping("/savecategorie")
    @ResponseBody
    public Categorie saveCategories( @RequestBody Categorie categorie)
    {
        return categorieService.saveCategories(categorie);
    }
    
    @GetMapping("/getAll")
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


