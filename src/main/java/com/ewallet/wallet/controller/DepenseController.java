package com.ewallet.wallet.controller;

import java.util.List;

import com.ewallet.wallet.service.mapper.DepenseMapper;
import com.ewallet.wallet.service.mapper.RevenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.ewallet.wallet.entities.Depense;
import com.ewallet.wallet.service.DepenseService;
import com.ewallet.wallet.service.dto.DepenseDto;

@RestController
@RequestMapping(value = "/depenses")
public class DepenseController {

    @Autowired
    private DepenseService depenseService;
    

    

    @PostMapping("/saveDepense")
    @ResponseBody
    public DepenseDto saveDepenses(@RequestBody DepenseDto depenseDto) {
        return depenseService.saveDepense(depenseDto);
    }

    @GetMapping("/getDepense/{id}")
    @ResponseBody

    public DepenseDto getDepense(@PathVariable Long id) {
        return depenseService.getDepense(id);
    }

    @GetMapping("/getOwnDepenses")
    @ResponseBody

    public List<Depense> getOwnDepenses(Authentication authentication) {
        return depenseService.getOwnDepenses(authentication);
    }

 

    @DeleteMapping("/deleteDepenses/{id}")
    @ResponseBody
    public void deleteDepensesById(@PathVariable("id") Long idDepense) {
        depenseService.deleteDepensesById(idDepense);

    }

   

    @GetMapping("/getLastDepenses")
    @ResponseBody

    public List<Depense> findLastDepenses(Authentication authentication) {
        return depenseService.findLastDepenses(authentication);
    }

    @GetMapping("/totalDepense/{idUser}")
    public Double getTotalDepenseAmount(@PathVariable("idUser")Long idUser) {
        return depenseService.getTotalDepenseAmount(idUser);
    }

    @GetMapping("/getPaiementsPrevus")
    @ResponseBody

    public List<Depense> getPaiementsPrevus(Authentication authentication) {
        return depenseService.getPaiementsPrevus(authentication);
    }
    @GetMapping("/chartDepRevData")
    List<List<Object>>  chartDepenseRevenuData(Authentication authentication){
        return depenseService.chartDepenseRevenuData(authentication);
    };

    @GetMapping("/notifPaiementPrevu")
    public List<Object> notifPaiementPrevu(Authentication authentication) {
    return depenseService.notifPaiementPrevu(authentication);
    }

    @PutMapping("/doPaiementPrevu/{id}")
    public void doPaiementPrevu(@PathVariable("id")Long id) {
        depenseService.doPaiementPrevu(id);
    }
}
