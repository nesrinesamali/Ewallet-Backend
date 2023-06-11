package com.nesryne.wallet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nesryne.wallet.entities.Categorie;
import com.nesryne.wallet.entities.Depense;
import com.nesryne.wallet.entities.Utilisateur;
import com.nesryne.wallet.repository.CategorieRepository;
import com.nesryne.wallet.repository.DepenseRepository;
import com.nesryne.wallet.repository.UtilisateurRepository;
import com.nesryne.wallet.service.dto.DepenseDto;
import com.nesryne.wallet.service.mapper.DepenseMapper;
@Component
@Service
public class DepenseServiceImpl implements DepenseService {
    @Autowired
    DepenseRepository depenseRepository;

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    CategorieRepository categorieRepository;

    @Autowired
    DepenseMapper depenseMapper;
      public DepenseServiceImpl(DepenseMapper depenseMapper,DepenseRepository depenseRepository){
        this.depenseMapper=depenseMapper;
        this.depenseRepository=depenseRepository;
      }




@Override
public DepenseDto saveDepenses(DepenseDto depenseDto) {
    Depense depense= depenseMapper.toEntity(depenseDto);

    Optional<Utilisateur> utilisateurOpt = utilisateurRepository.findById(depenseDto.getUserId());
    Utilisateur utilisateur = utilisateurOpt.isPresent()?utilisateurOpt.get():null;
    if(utilisateur!=null){
        utilisateur.getDepenses().add(depense);
    }
    Optional<Categorie> categorieOpt = categorieRepository.findById(depenseDto.getCategorieId());
    Categorie categorie = categorieOpt.isPresent()?categorieOpt.get():null;
    if(categorie!=null){
        categorie.getDepenses().add(depense);
    }
    

    depenseRepository.save(depense);
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
    
}
