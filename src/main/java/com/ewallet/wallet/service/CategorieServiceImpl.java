package com.ewallet.wallet.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.ewallet.wallet.entities.Categorie;
import com.ewallet.wallet.entities.Utilisateur;
import com.ewallet.wallet.repository.CategorieRepository;
import com.ewallet.wallet.repository.UtilisateurRepository;
import com.ewallet.wallet.service.dto.CategorieDto;
import com.ewallet.wallet.service.dto.CategorieDepenseDto;
import com.ewallet.wallet.service.mapper.CategorieMapper;

@Service
public class CategorieServiceImpl implements CategorieService  {
   

@Autowired
CategorieRepository CategorieRepository;
@Autowired
CategorieMapper categorieMapper;

@Autowired
UtilisateurRepository utilisateurRepository;
 
public CategorieServiceImpl(CategorieMapper categorieMapper,CategorieRepository categorieRepository){
    this.categorieMapper=categorieMapper;
    this.CategorieRepository=categorieRepository;
}




@Override
public Categorie saveCategories(Categorie categorie , Authentication authentication) {
    // Utilisateur utilisateur = utilisateurRepository.findByEmail(authentication.getName()).get();
//    Categorie categorie=categorieMapper.toEntity(categorieDto);
//    categorie=CategorieRepository.save(categorie);
//    return categorieMapper.toDto(categorie);
// categorie.setCreatorId(utilisateur.getIdUtilisateur());
    return CategorieRepository.save(categorie);
}

@Override
public CategorieDto updateCategories(CategorieDto categorieDto) {
    Categorie categorie=categorieMapper.toEntity(categorieDto);
    categorie=CategorieRepository.save(categorie);
    return categorieMapper.toDto(categorie);}

@Override
public void deleteCategoriesById(Long idCategorie) {
    CategorieRepository.deleteById(idCategorie);
}
@Override
public Categorie getCategories(Long idCategorie) {
    return CategorieRepository.findById(idCategorie).get();}
@Override
public List<Categorie> getAllCategories() {
    return CategorieRepository.findAll();
}

public List<CategorieDepenseDto> listDepenseByCategory() {
    List<Object[]> results = CategorieRepository.listDepenseByCategory();
     List<CategorieDepenseDto> catDepDtos = new ArrayList<>() ;
     for (Object[] result :results ){
        catDepDtos.add(new CategorieDepenseDto((String)result[0], (Double)result[1]));
     }
  return catDepDtos ;
    }




@Override
public List<Object> listBudgetAtteint() {
    return CategorieRepository.listBudgetAtteint();
}
}

