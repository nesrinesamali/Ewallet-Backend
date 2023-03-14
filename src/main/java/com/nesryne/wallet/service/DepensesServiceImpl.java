package com.nesryne.wallet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nesryne.wallet.entities.Depenses;
import com.nesryne.wallet.repository.DepensesRepository;
import com.nesryne.wallet.service.dto.DepensesDto;
import com.nesryne.wallet.service.mapper.DepensesMapper;
@Component
@Service
public class DepensesServiceImpl implements DepensesService {
    @Autowired
    DepensesRepository DepensesRepository;
    @Autowired
    DepensesMapper depensesMapper;
      public DepensesServiceImpl(DepensesMapper depensesMapper,DepensesRepository depensesRepository){
        this.depensesMapper=depensesMapper;
        this.DepensesRepository=depensesRepository;
      }




@Override
public DepensesDto saveDepenses(DepensesDto depensesDto) {
    Depenses depenses= depensesMapper.toEntity(depensesDto);
    depenses=DepensesRepository.save(depenses);
    return depensesMapper.toDto(depenses);
    }

@Override
public DepensesDto updateDepenses(DepensesDto depensesDto) {
    Depenses depenses= depensesMapper.toEntity(depensesDto);
    depenses=DepensesRepository.save(depenses);
    return depensesMapper.toDto(depenses);}

@Override
public void deleteDepensesById(Long idDepenses) {
    DepensesRepository.deleteById(idDepenses);
}
@Override
public Depenses getDepenses(Long idDepenses) {
    return DepensesRepository.findById(idDepenses).get();}
@Override
public List<Depenses> getAllDepenses() {
    return DepensesRepository.findAll();
}
    
}
