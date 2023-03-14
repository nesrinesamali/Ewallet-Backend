package com.nesryne.wallet.service;

import java.util.List;

import com.nesryne.wallet.entities.Budget;
import com.nesryne.wallet.service.dto.BudgetDto;

public interface BudgetService {
   
    
        BudgetDto  saveBudget(BudgetDto budgetDto);
        BudgetDto  updateBudget(BudgetDto budgetDto);
        void deleteBudgetById(Long idBudget);
        Budget getBudget(Long idBudget);
        List<Budget > getAllBudgets();
        
        
}
