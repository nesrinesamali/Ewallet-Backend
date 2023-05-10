package com.nesryne.wallet.controller;

import java.util.List;

import com.nesryne.wallet.service.mapper.CategorieMapper;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
// import org.springframework.web.bind.annotation.RequestMapping;
=======
import org.springframework.web.bind.annotation.*;
>>>>>>> 25fd4dbdc315cbcd7fe82e7efda1a699e6dffeaf

import com.nesryne.wallet.entities.Categorie;
import com.nesryne.wallet.service.CategorieService;
import com.nesryne.wallet.service.dto.CategorieDto;

<<<<<<< HEAD
=======
@RequestMapping("/categories")
>>>>>>> 25fd4dbdc315cbcd7fe82e7efda1a699e6dffeaf
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CategorieController {
    @Autowired
    private CategorieService categorieService;

    @Autowired
    private CategorieMapper categorieMapper;

<<<<<<< HEAD
    @PostMapping("/saveCategorie")
=======
    public CategorieController(CategorieMapper categorieMapper) {
        this.categorieMapper = categorieMapper;

    }
    @PostMapping("/savecategorie")
>>>>>>> 25fd4dbdc315cbcd7fe82e7efda1a699e6dffeaf
    @ResponseBody
    public Categorie saveCategories( @RequestBody Categorie categorie)
    {
        return categorieService.saveCategories(categorie);
    }
    
<<<<<<< HEAD
    @GetMapping("/categories")
=======
    @GetMapping("/getAll")
    @ResponseBody
>>>>>>> 25fd4dbdc315cbcd7fe82e7efda1a699e6dffeaf
 
 
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


