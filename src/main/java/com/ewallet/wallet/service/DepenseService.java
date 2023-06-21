package com.ewallet.wallet.service;

import java.util.List;

import com.ewallet.wallet.entities.Depense;
import com.ewallet.wallet.service.dto.DepenseDto;

public interface DepenseService {
    DepenseDto  saveDepenses(DepenseDto depenseDto);
    DepenseDto   updateDepenses(DepenseDto depenseDto);
    void deleteDepensesById(Long idDepense);
    Depense  getDepenses(Long idDepense);
    List<Depense  > getAllDepenses();
    
}
