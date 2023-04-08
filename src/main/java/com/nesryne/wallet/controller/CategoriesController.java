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

import com.nesryne.wallet.entities.Categories;
import com.nesryne.wallet.service.CategoriesService;
import com.nesryne.wallet.service.dto.CategoriesDto;


@RestController
public class CategoriesController {
    @Autowired
    private CategoriesService categoriesService;


    @PostMapping("/Categories")
    @ResponseBody
    public CategoriesDto saveCategories( @RequestBody CategoriesDto categoriesDto)
    {
        return categoriesService.saveCategories(categoriesDto);
    }
    
    @GetMapping("/getCategoriess")
    @ResponseBody
 
    public List<Categories> getAllCategoriess() {
        return categoriesService.getAllCategories();
    }
 
    @PutMapping("/updateCategories")
 
    public CategoriesDto
    updateCategories(@RequestBody CategoriesDto categoriesDto)
    {
        return categoriesService.updateCategories(categoriesDto);
    }
 
    
    @DeleteMapping("/deleteCategories/{id}")
 @ResponseBody
    public void deleteCategoriesById(@PathVariable("id") Long idCategories)
    {
        categoriesService.deleteCategoriesById(idCategories);
         
        }
    @GetMapping("/moncategories")
    @ResponseBody
 
    public Categories getCategories(@PathVariable("id") Long idCategories) {
        return categoriesService.getCategories(idCategories);

        
        
        
}
}


