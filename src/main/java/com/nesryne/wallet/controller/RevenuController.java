package com.nesryne.wallet.controller;



import java.util.List;

import com.nesryne.wallet.repository.RevenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nesryne.wallet.entities.Revenu;
import com.nesryne.wallet.service.RevenuService;
import com.nesryne.wallet.service.dto.RevenuDto;
 import com.nesryne.wallet.service.mapper.RevenuMapper;

@RestController
<<<<<<< HEAD
@CrossOrigin(origins = "http://localhost:4200")
=======

>>>>>>> 25fd4dbdc315cbcd7fe82e7efda1a699e6dffeaf
public class RevenuController {
    @Autowired
    private RevenuService revenuService;
     @Autowired
     private RevenuMapper revenuMapper;

    public RevenuController(RevenuMapper revenuMapper) {
        this.revenuMapper = revenuMapper;

    }

    @PostMapping("/saveRevenu")
    @ResponseBody
    public RevenuDto saveRevenu( @RequestBody RevenuDto revenuDto)
    {
        return revenuService.saveRevenu(revenuDto);
    }
    
    @GetMapping("/revenus")
    @ResponseBody
 
    public List<Revenu> getAllRevenus() {
          return revenuService.getAllRevenus();    
    }
    @GetMapping("/monRevenu")
    @ResponseBody
 
    public Revenu getRevenu(@PathVariable("id") Long idRevenu) {
        return revenuService.getRevenu(idRevenu);

    }
    @PutMapping("/updateRevenu")
    @ResponseBody
    public RevenuDto updateRevenu( @RequestBody RevenuDto revenuDto)
    {
        return revenuService.updateRevenu(revenuDto);
    }
    
    @DeleteMapping("/deleteRevenu/{id}")
    @ResponseBody
    public String deleteRevenuById(@PathVariable("id") Long idRevenu)
    {
        revenuService.deleteRevenuById(idRevenu);
        return "Deleted Successfully";
    }
}
