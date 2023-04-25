package com.nesryne.wallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;

import com.nesryne.wallet.entities.Utilisateur;
import com.nesryne.wallet.service.UtilisateurService;
import com.nesryne.wallet.service.dto.UtilisateurDto;
// import com.nesryne.wallet.service.mapper.UtilisateurMapper;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;
    // @Autowired
    // private UtilisateurMapper utilisateurMapper;
    
    @PostMapping("/saveUtilisateur")
    @ResponseBody
    public UtilisateurDto saveUtilisateur( @RequestBody UtilisateurDto utilisateurDto)
    {
        return utilisateurService.saveUtilisateur(utilisateurDto);
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
