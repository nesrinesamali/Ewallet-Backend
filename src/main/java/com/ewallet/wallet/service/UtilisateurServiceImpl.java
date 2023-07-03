package com.ewallet.wallet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ewallet.wallet.entities.Depense;
import com.ewallet.wallet.entities.Revenu;
import com.ewallet.wallet.entities.Utilisateur;
import com.ewallet.wallet.repository.RevenuRepository;
import com.ewallet.wallet.repository.UtilisateurRepository;
import com.ewallet.wallet.service.dto.ProfileDto;
import com.ewallet.wallet.service.dto.UtilisateurDto;
import com.ewallet.wallet.service.mapper.UtilisateurMapper;


@Service
public class UtilisateurServiceImpl implements UtilisateurService{
    

private final UtilisateurRepository utilisateurRepository;
private final UtilisateurMapper  utilisateurMapper;
private final BCryptPasswordEncoder bCryptPasswordEncoder;

public UtilisateurServiceImpl(UtilisateurMapper utilisateurMapper,
UtilisateurRepository  utilisateurRepository,
BCryptPasswordEncoder bCryptPasswordEncoder
) {
    this.utilisateurMapper = utilisateurMapper;
    this.utilisateurRepository= utilisateurRepository;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
}

@Override
public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
//    Utilisateur utilisateur=utilisateurMapper.toEntity(utilisateurDto);
//    utilisateur=utilisateurRepository.save(utilisateur);
//    return utilisateurMapper.toDto(utilisateur);
utilisateur.setMotDePasse(bCryptPasswordEncoder.encode(utilisateur.getMotDePasse()));
utilisateur.setRole("ROLE_USER");

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
    return utilisateurRepository.findAllByRole("ROLE_USER");
}
@Override
public Double getSoldeDeCompte(Long idUser) {
    return utilisateurRepository.getSoldeDeCompte(idUser);
}

@Override
public ProfileDto getProfile(Authentication authentication) {
    String email=authentication.getName();
    Utilisateur utilisateur=utilisateurRepository.findByEmail(email).get();
    ProfileDto profile = new ProfileDto();
    profile.setId(utilisateur.getIdUtilisateur());
    profile.setNom(utilisateur.getNom());
    profile.setPrenom(utilisateur.getPrenom());
    profile.setEmail(email);
    profile.setSolde(getSoldeDeCompte(utilisateur.getIdUtilisateur()));
    return profile ;
}

@Override
public void updateProfile(ProfileDto profileDto) {
    Utilisateur utilisateur=utilisateurRepository.findById(profileDto.getId()).get();
    utilisateur.setNom(profileDto.getNom());
    utilisateur.setPrenom(profileDto.getPrenom());
    utilisateur.setEmail(profileDto.getEmail());
    utilisateurRepository.save(utilisateur);

}

}
