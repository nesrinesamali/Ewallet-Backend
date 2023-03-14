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

import com.nesryne.wallet.entities.Depenses;
import com.nesryne.wallet.service.DepensesService;
import com.nesryne.wallet.service.dto.DepensesDto;
@RestController
public class DepensesController {

    @Autowired
    private DepensesService depensesService;


    @PostMapping("/Depenses")
    @ResponseBody
    public DepensesDto saveDepenses( @RequestBody DepensesDto depensesDto)
    {
        return depensesService.saveDepenses(depensesDto);
    }
    
    @GetMapping("/getDepenses")
    @ResponseBody
 
    public List<Depenses> getAllBudgets() {
        return depensesService.getAllDepenses();
    }
 
    @PutMapping("/updateDepenses")
 
    public DepensesDto
    updateDepenses(@RequestBody DepensesDto depensesDto)
    {
        return depensesService.updateDepenses(depensesDto);
    }
 
    
    @DeleteMapping("/deleteDepenses/{id}")
 @ResponseBody
    public void deleteDepensesById(@PathVariable("id") Long idDepenses)
    {
        depensesService.deleteDepensesById(idDepenses);
         
        }
    @GetMapping("/mesDepenses")
    @ResponseBody
 
    public Depenses getDepenses(@PathVariable("id") Long idDepenses) {
        return depensesService.getDepenses(idDepenses);

        
        
        
}
}


    

