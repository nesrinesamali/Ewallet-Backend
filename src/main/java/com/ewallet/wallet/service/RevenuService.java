package com.ewallet.wallet.service;

import java.util.List;

import com.ewallet.wallet.entities.Revenu;
import com.ewallet.wallet.service.dto.RevenuDto;



public interface RevenuService {
    
RevenuDto  saveRevenu(RevenuDto revenuDto);
RevenuDto  updateRevenu(RevenuDto revenuDto);
void deleteRevenuById(Long idRevenu);
Revenu getRevenu(Long idRevenu);
List<Revenu> getAllRevenus();
Double getTotalRevenuAmount();
}

