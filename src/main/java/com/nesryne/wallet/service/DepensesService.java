package com.nesryne.wallet.service;

import java.util.List;

import com.nesryne.wallet.entities.Depenses;
import com.nesryne.wallet.service.dto.DepensesDto;

public interface DepensesService {
    DepensesDto  saveDepenses(DepensesDto depensesDto);
    DepensesDto   updateDepenses(DepensesDto depensesDto);
    void deleteDepensesById(Long idDepenses);
    Depenses  getDepenses(Long idDepenses);
    List<Depenses  > getAllDepenses();
    
}
