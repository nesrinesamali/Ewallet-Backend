package com.ewallet.wallet.service;

import java.util.List;

import com.ewallet.wallet.entities.Utilisateur;
import com.ewallet.wallet.service.dto.UtilisateurDto;

public interface UtilisateurService {

    Utilisateur saveUtilisateur(Utilisateur utilisateur);
    UtilisateurDto  updateUtilisateur(UtilisateurDto utilisateurDto);
    void deleteUtilisateurById(Long idUtilisateur);
    Utilisateur getUtilisateur(Long idUtilisateur);
    List<Utilisateur> getAllUtilisateurs();
    Double getSoldeDeCompte();
}
