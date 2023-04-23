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

import com.nesryne.wallet.entities.Revenu;
import com.nesryne.wallet.service.RevenuService;
import com.nesryne.wallet.service.dto.RevenuDto;
// import com.nesryne.wallet.service.mapper.RevenuMapper;

@RestController
public class RevenuController {
    @Autowired
    private RevenuService revenuService;
    // @Autowired
    // private RevenuMapper revenuMapper;
    
    @PostMapping("/SaveRevenu")
    @ResponseBody
    public RevenuDto saveRevenu( @RequestBody RevenuDto revenuDto)
    {
        return revenuService.saveRevenu(revenuDto);
    }
    
    @GetMapping("/Revenus")
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
