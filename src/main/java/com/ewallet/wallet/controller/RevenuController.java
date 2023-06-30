package com.ewallet.wallet.controller;



import java.util.List;

import com.ewallet.wallet.repository.RevenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.ewallet.wallet.entities.Depense;
import com.ewallet.wallet.entities.Revenu;
import com.ewallet.wallet.service.RevenuService;
import com.ewallet.wallet.service.dto.RevenuDto;
 import com.ewallet.wallet.service.mapper.RevenuMapper;

@RestController
@RequestMapping(value = "/revenus")
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
 
 

    @GetMapping("/getOwnRevenus")
    @ResponseBody
    public List<Revenu> getOwnRevenus(Authentication authentication) {
        return revenuService.getOwnRevenus(authentication);
    }
    
    @GetMapping("/getRevenu/{id}")
    @ResponseBody

    public RevenuDto getRevenu(@PathVariable Long id) {
        return revenuService.getRevenu(id);
    }

    @DeleteMapping("/deleteRevenu/{id}")
    @ResponseBody
    public String deleteRevenuById(@PathVariable("id") Long idRevenu)
    {
        revenuService.deleteRevenuById(idRevenu);
        return "Deleted Successfully";
    }

    @GetMapping("/totalRevenu")
    public Double getTotalRevenuAmount() {
        return revenuService.getTotalRevenuAmount();
    }
}
