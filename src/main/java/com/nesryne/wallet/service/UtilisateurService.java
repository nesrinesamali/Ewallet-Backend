package com.nesryne.wallet.service;

import java.util.List;

import com.nesryne.wallet.entities.Utilisateur;
import com.nesryne.wallet.service.dto.UtilisateurDto;

public interface UtilisateurService {

    UtilisateurDto  saveUtilisateur(UtilisateurDto utilisateurDto);
    UtilisateurDto  updateUtilisateur(UtilisateurDto utilisateurDto);
    void deleteUtilisateurById(Long idUtilisateur);
    Utilisateur getUtilisateur(Long idUtilisateur);
    List<Utilisateur> getAllUtilisateurs();
}
