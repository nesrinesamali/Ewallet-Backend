package com.nesryne.wallet.service;

import java.util.List;

import com.nesryne.wallet.entities.Budget;

public interface BudgetService {
   
    
        Budget  saveBudget(Budget budget);
        Budget  updateBudget(Budget budget);
        void deleteBudgetById(Long idBudget);
        Budget getBudget(Long idBudget);
        List<Budget > getAllBudgets();
        
        
}
