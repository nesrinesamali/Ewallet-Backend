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

import com.nesryne.wallet.entities.Budget;
import com.nesryne.wallet.service.BudgetService;


@RestController
public class BudgetController {
    @Autowired
    private BudgetService budgetService;


    @PostMapping("/Budgets")
    @ResponseBody
    public Budget saveBudget( @RequestBody Budget budget)
    {
        return budgetService.saveBudget(budget);
    }
    
    @GetMapping("/getBudgets")
    @ResponseBody
 
    public List<Budget> getAllBudgets() {
        return budgetService.getAllBudgets();
    }
 
    @PutMapping("/updateBudget")
 
    public Budget
    updateBudget(@RequestBody Budget budget)
    {
        return budgetService.updateBudget(budget);
    }
 
    
    @DeleteMapping("/deleteBudget/{id}")
 @ResponseBody
    public void deleteBudgetById(@PathVariable("id") Long idBudget)
    {
        budgetService.deleteBudgetById(idBudget);
         
        }
    @GetMapping("/monbudget")
    @ResponseBody
 
    public Budget getBudget(@PathVariable("id") Long idBudget) {
        return budgetService.getBudget(idBudget);

        
        
        
}
}


