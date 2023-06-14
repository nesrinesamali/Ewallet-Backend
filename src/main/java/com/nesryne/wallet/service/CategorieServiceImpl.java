package com.nesryne.wallet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.nesryne.wallet.entities.Categorie;
import com.nesryne.wallet.entities.Utilisateur;
import com.nesryne.wallet.repository.CategorieRepository;
import com.nesryne.wallet.repository.UtilisateurRepository;
import com.nesryne.wallet.service.dto.CategorieDto;
import com.nesryne.wallet.service.mapper.CategorieMapper;

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
    Utilisateur utilisateur = utilisateurRepository.findByEmail(authentication.getName()).get();
//    Categorie categorie=categorieMapper.toEntity(categorieDto);
//    categorie=CategorieRepository.save(categorie);
//    return categorieMapper.toDto(categorie);
categorie.setCreatorId(utilisateur.getIdUtilisateur());
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
}

