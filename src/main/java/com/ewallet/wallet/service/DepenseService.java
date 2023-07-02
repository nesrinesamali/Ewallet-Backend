package com.ewallet.wallet.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.security.core.Authentication;

import com.ewallet.wallet.entities.Depense;
import com.ewallet.wallet.service.dto.DepenseDto;

public interface DepenseService {
    DepenseDto  saveDepense(DepenseDto depenseDto);
 
    void deleteDepensesById(Long idDepense);
    DepenseDto  getDepense(Long idDepense);
    List<Depense > getOwnDepenses(Authentication authentication);
    List<Depense> findLastDepenses();
    Double getTotalDepenseAmount(Long idUser);
    List<Depense> getPaiementsPrevus();
    List<List<Object>>  chartDepenseRevenuData();
    List<Object> notifPaiementPrevu();
    void doPaiementPrevu(Long id);
}
