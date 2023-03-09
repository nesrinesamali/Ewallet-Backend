package com.nesryne.wallet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nesryne.wallet.entities.Depenses;
import com.nesryne.wallet.repository.DepensesRepository;

@Service
public class DepensesServiceImpl implements DepensesService {
    @Autowired
    DepensesRepository DepensesRepository;
@Override
public Depenses saveDepenses(Depenses depenses) {
    return DepensesRepository.save(depenses);}

@Override
public Depenses updateDepenses(Depenses depenses) {
    return DepensesRepository.save(depenses);}

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
