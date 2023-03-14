package com.nesryne.wallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nesryne.wallet.entities.Utilisateur;
import com.nesryne.wallet.service.UtilisateurService;
import com.nesryne.wallet.service.dto.UtilisateurDto;
// import com.nesryne.wallet.service.mapper.UtilisateurMapper;

@RestController
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;
    // @Autowired
    // private UtilisateurMapper utilisateurMapper;
    
    @PostMapping("/SaveUtilisateur")
    @ResponseBody
    public UtilisateurDto saveUtilisateur( @RequestBody UtilisateurDto utilisateurDto)
    {
        return utilisateurService.saveUtilisateur(utilisateurDto);
    }
    
    @GetMapping("/Utilisateurs")
    @ResponseBody
 
    public List<Utilisateur> getAllUtilisateurs() {
         return utilisateurService.getAllUtilisateurs();
    }
 
    @PutMapping("/updateUtilisateur")
    @ResponseBody
    public UtilisateurDto updateUtilisateur( @RequestBody UtilisateurDto utilisateurDto)
    {
        return utilisateurService.updateUtilisateur(utilisateurDto);
    }
    
    @DeleteMapping("/deleteUtilisateur/{id}")
    @ResponseBody
    public String deleteUtilisateurById(@PathVariable("id") Long idUtilisateur)
    {
        utilisateurService.deleteUtilisateurById(idUtilisateur);
        return "Deleted Successfully";
    }
}
