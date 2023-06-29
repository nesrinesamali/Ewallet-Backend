package com.ewallet.wallet.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ewallet.wallet.entities.Depense;
import com.ewallet.wallet.repository.DepenseRepository;
import com.ewallet.wallet.service.dto.DepenseDto;
import com.ewallet.wallet.service.mapper.DepenseMapper;
import com.ewallet.wallet.entities.Categorie;

import com.ewallet.wallet.entities.Utilisateur;
import com.ewallet.wallet.repository.CategorieRepository;

import com.ewallet.wallet.repository.UtilisateurRepository;


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
public DepenseDto saveDepense(DepenseDto depenseDto) {
    Depense depense= DepenseDto.toEntity(depenseDto);

  
        Optional<Utilisateur> utilisateurOpt = utilisateurRepository.findById(depenseDto.getUserId());
        Utilisateur utilisateur = utilisateurOpt.isPresent()?utilisateurOpt.get():null;
        depense.setUtilisateur(utilisateur);
    

    Optional<Categorie> categorieOpt = categorieRepository.findById(depenseDto.getCategorieId());
        Categorie categorie = categorieOpt.isPresent()?categorieOpt.get():null;
        depense.setCategorie(categorie);
   
    

    depenseRepository.save(depense);
    return depenseMapper.toDto(depense);
    }



@Override
public void deleteDepensesById(Long idDepense) {
    depenseRepository.deleteById(idDepense);
}
@Override
public DepenseDto getDepense(Long idDepense) {
    return DepenseDto.fromEntity(depenseRepository.findById(idDepense).get());}
@Override
public List<Depense> getOwnDepenses(Authentication authentication) {
    System.out.println("auth " + authentication.getName());
    String email=authentication.getName();
    Utilisateur utilisateur=utilisateurRepository.findByEmail(email).get();
    return depenseRepository.findAllByUtilisateurIdUtilisateur(utilisateur.getIdUtilisateur());
}




@Override
public List<Depense> findLastDepenses() {
    return depenseRepository.findLastDepenses();
}
@Override
public Double getTotalDepenseAmount() {
    return depenseRepository.getTotalDepenseAmount();
}

@Override
public List<Depense> getPaiementsPrevus() {
    return depenseRepository.getPaiementsPrevus();
}   
}
