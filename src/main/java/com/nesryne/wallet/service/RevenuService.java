package com.nesryne.wallet.service;

import java.util.List;

import com.nesryne.wallet.entities.Revenu;
import com.nesryne.wallet.service.dto.RevenuDto;



public interface RevenuService {
    
RevenuDto  saveRevenu(RevenuDto revenuDto);
RevenuDto  updateRevenu(RevenuDto revenuDto);
void deleteRevenuById(Long idRevenu);
Revenu getRevenu(Long idRevenu);
List<Revenu> getAllRevenus();
}

