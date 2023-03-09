package com.nesryne.wallet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nesryne.wallet.entities.Budget;
import com.nesryne.wallet.repository.BudgetRepository;

@Service
public class BudgetServiceImpl implements BudgetService  {
   

@Autowired
BudgetRepository BudgetRepository;
@Override
public Budget saveBudget(Budget budget) {
    return BudgetRepository.save(budget);}

@Override
public Budget updateBudget(Budget budget) {
    return BudgetRepository.save(budget);}

@Override
public void deleteBudgetById(Long idBudget) {
    BudgetRepository.deleteById(idBudget);
}
@Override
public Budget getBudget(Long idBudget) {
    return BudgetRepository.findById(idBudget).get();}
@Override
public List<Budget> getAllBudgets() {
    return BudgetRepository.findAll();
}
}

