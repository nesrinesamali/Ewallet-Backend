package com.ewallet.wallet.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ewallet.wallet.entities.Depense;
import com.ewallet.wallet.repository.DepenseRepository;
import com.ewallet.wallet.service.dto.DepenseDto;
import com.ewallet.wallet.service.mapper.DepenseMapper;
@Component
@Service
public class DepenseServiceImpl implements DepenseService {
    @Autowired
    DepenseRepository depenseRepository;
    @Autowired
    DepenseMapper depenseMapper;
      public DepenseServiceImpl(DepenseMapper depenseMapper,DepenseRepository depenseRepository){
        this.depenseMapper=depenseMapper;
        this.depenseRepository=depenseRepository;
      }




@Override
public DepenseDto saveDepenses(DepenseDto depenseDto) {
    Depense depense= depenseMapper.toEntity(depenseDto);
    depense=depenseRepository.save(depense);
    return depenseMapper.toDto(depense);
    }

@Override
public DepenseDto updateDepenses(DepenseDto depenseDto) {
    Depense depense= depenseMapper.toEntity(depenseDto);
    depense=depenseRepository.save(depense);
    return depenseMapper.toDto(depense);}

@Override
public void deleteDepensesById(Long idDepense) {
    depenseRepository.deleteById(idDepense);
}
@Override
public Depense getDepenses(Long idDepense) {
    return depenseRepository.findById(idDepense).get();}
@Override
public List<Depense> getAllDepenses() {
    return depenseRepository.findAll();
}




@Override
public List<Depense> findLastDepenses() {
    return depenseRepository.findLastDepenses();
}
@Override
public Double getTotalDepenseAmount() {
    return depenseRepository.getTotalDepenseAmount();
}
    
}
