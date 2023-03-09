package com.nesryne.wallet.service;

import java.util.List;


import com.nesryne.wallet.entities.Depenses;

public interface DepensesService {
    Depenses  saveDepenses(Depenses depenses);
    Depenses   updateDepenses(Depenses depenses);
    void deleteDepensesById(Long idDepenses);
    Depenses  getDepenses(Long idDepenses);
    List<Depenses  > getAllDepenses();
    
}
