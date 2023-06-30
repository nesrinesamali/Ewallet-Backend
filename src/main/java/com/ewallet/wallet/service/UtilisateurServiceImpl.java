package com.ewallet.wallet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ewallet.wallet.entities.Depense;
import com.ewallet.wallet.entities.Revenu;
import com.ewallet.wallet.entities.Utilisateur;
import com.ewallet.wallet.repository.RevenuRepository;
import com.ewallet.wallet.repository.UtilisateurRepository;
import com.ewallet.wallet.service.dto.UtilisateurDto;
import com.ewallet.wallet.service.mapper.UtilisateurMapper;

@Component
@Service
public class UtilisateurServiceImpl implements UtilisateurService{
    
@Autowired
private final UtilisateurRepository utilisateurRepository;
private final UtilisateurMapper  utilisateurMapper;


public UtilisateurServiceImpl(UtilisateurMapper utilisateurMapper,UtilisateurRepository  utilisateurRepository) {
    this.utilisateurMapper = utilisateurMapper;
    this.utilisateurRepository= utilisateurRepository;
}

@Override
public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
//    Utilisateur utilisateur=utilisateurMapper.toEntity(utilisateurDto);
//    utilisateur=utilisateurRepository.save(utilisateur);
//    return utilisateurMapper.toDto(utilisateur);
    return utilisateurRepository.save(utilisateur);
}



    @Override
public UtilisateurDto updateUtilisateur(UtilisateurDto utilisateurDto) {
    Utilisateur utilisateur=utilisateurMapper.toEntity(utilisateurDto);
    utilisateur=utilisateurRepository.save(utilisateur);
    return utilisateurMapper.toDto(utilisateur);
  }

@Override
public void deleteUtilisateurById(Long idUtilisateur) {
    utilisateurRepository.deleteById(idUtilisateur);
}
@Override
public Utilisateur getUtilisateur(Long idUtilisateur) {
    return utilisateurRepository.findById(idUtilisateur).get();}
@Override
public List<Utilisateur> getAllUtilisateurs() {
    return utilisateurRepository.findAll();
}
@Override
public Double getSoldeDeCompte() {
    return utilisateurRepository.getSoldeDeCompte();
}

}
