package com.nesryne.wallet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nesryne.wallet.entities.Utilisateur;
import com.nesryne.wallet.repository.UtilisateurRepository;
import com.nesryne.wallet.service.dto.UtilisateurDto;
import com.nesryne.wallet.service.mapper.UtilisateurMapper;

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
public UtilisateurDto  saveUtilisateur(UtilisateurDto utilisateurDto) {
    Utilisateur utilisateur=utilisateurMapper.toEntity(utilisateurDto);
    utilisateur=utilisateurRepository.save(utilisateur);
    return utilisateurMapper.toDto(utilisateur);}


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
}
