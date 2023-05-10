package com.nesryne.wallet.controller;

import java.util.List;

import com.nesryne.wallet.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;

import com.nesryne.wallet.entities.Utilisateur;
import com.nesryne.wallet.service.UtilisateurService;
import com.nesryne.wallet.service.dto.UtilisateurDto;
 import com.nesryne.wallet.service.mapper.UtilisateurMapper;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;
<<<<<<< HEAD
    // @Autowired
    // private UtilisateurMapper utilisateurMapper;
    
=======
     @Autowired
     private UtilisateurMapper utilisateurMapper;
    public UtilisateurController(UtilisateurMapper utilisateurMapper) {
        this.utilisateurMapper = utilisateurMapper;

    }

>>>>>>> 25fd4dbdc315cbcd7fe82e7efda1a699e6dffeaf
    @PostMapping("/saveUtilisateur")
    @ResponseBody
    public Utilisateur saveUtilisateur( @RequestBody Utilisateur utilisateur)
    {
        return utilisateurService.saveUtilisateur(utilisateur);
    }
    
    @GetMapping("/utilisateurs")
    @ResponseBody
 
    public List<Utilisateur> getAllUtilisateurs() {
         return utilisateurService.getAllUtilisateurs();
    }
    @GetMapping("/monUtilisateur")
    @ResponseBody
 
    public Utilisateur getUtilisateur(@PathVariable("id") Long idUtilisateur) {
        return utilisateurService.getUtilisateur(idUtilisateur);
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
