package com.ewallet.wallet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ewallet.wallet.entities.Revenu;
import com.ewallet.wallet.entities.Utilisateur;
import com.ewallet.wallet.repository.RevenuRepository;
import com.ewallet.wallet.repository.UtilisateurRepository;
import com.ewallet.wallet.service.dto.RevenuDto;
import com.ewallet.wallet.service.mapper.RevenuMapper;


@Component
@Service
public class RevenuServiceImpl implements RevenuService {
 @Autowired
    UtilisateurRepository utilisateurRepository;

@Autowired
RevenuRepository revenuRepository;


@Autowired
RevenuMapper revenuMapper;



    public RevenuServiceImpl(RevenuMapper revenuMapper,RevenuRepository  revenuRepository) {
        this.revenuMapper = revenuMapper;
        this.revenuRepository= revenuRepository;
    }

@Override
public RevenuDto  saveRevenu(RevenuDto revenuDto) {
    Revenu revenu=revenuMapper.toEntity(revenuDto);
    revenu=revenuRepository.save(revenu);
    return revenuMapper.toDto(revenu);}

@Override
public RevenuDto updateRevenu(RevenuDto revenuDto) {
    Revenu revenu=revenuMapper.toEntity(revenuDto);
    revenu=revenuRepository.save(revenu);
    return revenuMapper.toDto(revenu);}

@Override
public void deleteRevenuById(Long idRevenu) {
    revenuRepository.deleteById(idRevenu);
}
@Override
public Revenu getRevenu(Long idRevenu) {
    return revenuRepository.findById(idRevenu).get();}
    
@Override
public List<Revenu> getAllRevenus() {
    return revenuRepository.findAll();
}
@Override
public Double getTotalRevenuAmount() {
    return revenuRepository.getTotalRevenuAmount();
}
@Override
public List<Revenu> getOwnRevenus(Authentication authentication) {
    System.out.println("auth " + authentication.getName());
    String email=authentication.getName();
    Utilisateur utilisateur=utilisateurRepository.findByEmail(email).get();
    return revenuRepository.findAllByUtilisateurIdUtilisateur(utilisateur.getIdUtilisateur());
}

}
