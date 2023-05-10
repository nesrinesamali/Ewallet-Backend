package com.nesryne.wallet.service;

import java.util.List;

import com.nesryne.wallet.entities.Utilisateur;
import com.nesryne.wallet.service.dto.UtilisateurDto;

public interface UtilisateurService {

    Utilisateur saveUtilisateur(Utilisateur utilisateur);
    UtilisateurDto  updateUtilisateur(UtilisateurDto utilisateurDto);
    void deleteUtilisateurById(Long idUtilisateur);
    Utilisateur getUtilisateur(Long idUtilisateur);
    List<Utilisateur> getAllUtilisateurs();
}
