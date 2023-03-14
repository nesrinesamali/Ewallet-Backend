package com.nesryne.wallet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nesryne.wallet.entities.Budget;
import com.nesryne.wallet.repository.BudgetRepository;
import com.nesryne.wallet.service.dto.BudgetDto;
import com.nesryne.wallet.service.mapper.BudgetMapper;

@Service
public class BudgetServiceImpl implements BudgetService  {
   

@Autowired
BudgetRepository BudgetRepository;
@Autowired
BudgetMapper budgetMapper;

public BudgetServiceImpl(BudgetMapper budgetMapper,BudgetRepository budgetRepository){
    this.budgetMapper=budgetMapper;
    this.BudgetRepository=budgetRepository;
}




@Override
public BudgetDto saveBudget(BudgetDto budgetDto) {
    Budget budget=budgetMapper.toEntity(budgetDto);
    budget=BudgetRepository.save(budget);
    return budgetMapper.toDto(budget);}

@Override
public BudgetDto updateBudget(BudgetDto budgetDto) {
    Budget budget=budgetMapper.toEntity(budgetDto);
    budget=BudgetRepository.save(budget);
    return budgetMapper.toDto(budget);}

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

