package com.ewallet.wallet.service;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.ewallet.wallet.entities.Depense;
import com.ewallet.wallet.entities.Revenu;
import com.ewallet.wallet.service.dto.RevenuDto;



public interface RevenuService {
    
RevenuDto  saveRevenu(RevenuDto revenuDto);
void deleteRevenuById(Long idRevenu);
RevenuDto getRevenu(Long idRevenu);
List<Revenu> getAllRevenus();
List<Revenu > getOwnRevenus(Authentication authentication);
Double getTotalRevenuAmount();
}

