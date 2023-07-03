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
    List<Depense> findLastDepenses(Authentication authentication);
    Double getTotalDepenseAmount(Long idUser);
    List<Depense> getPaiementsPrevus(Authentication authentication);
    List<List<Object>>  chartDepenseRevenuData(Authentication authentication);
    List<Object> notifPaiementPrevu(Authentication authentication);
    void doPaiementPrevu(Long id);
}
