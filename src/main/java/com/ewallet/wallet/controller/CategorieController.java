package com.ewallet.wallet.controller;

import java.util.List;

import com.ewallet.wallet.service.mapper.CategorieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.ewallet.wallet.entities.Categorie;
import com.ewallet.wallet.service.CategorieService;
import com.ewallet.wallet.service.dto.CategorieDto;
import com.ewallet.wallet.service.dto.CategorieDepenseDto;

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
    @PostMapping("/saveCategorie")
    @ResponseBody
    public Categorie saveCategories( @RequestBody Categorie categorie , Authentication authentication)
    {

        return categorieService.saveCategories(categorie , authentication);
    }
    
    @GetMapping("/getAll")
    @ResponseBody
 
    public List<Categorie> getAllCategories(Authentication authentication) {
        return categorieService.getAllCategories(authentication);
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
    @GetMapping("/categorieDepense")
    public List<CategorieDepenseDto> listDepenseByCategory() {
    return categorieService.listDepenseByCategory();
    }
    @GetMapping("/listBudgetAtteint")
    public List<Object> listBudgetAtteint(Authentication authentication) {
    return categorieService.listBudgetAtteint(authentication);
    }
}


