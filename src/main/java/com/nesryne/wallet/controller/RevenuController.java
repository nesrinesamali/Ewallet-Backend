package com.nesryne.wallet.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nesryne.wallet.entities.Revenu;
import com.nesryne.wallet.service.RevenuService;
import com.nesryne.wallet.service.dto.RevenuDto;
// import com.nesryne.wallet.service.mapper.RevenuMapper;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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
