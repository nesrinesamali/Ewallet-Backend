package com.ewallet.wallet.controller;

import java.util.List;

import com.ewallet.wallet.service.mapper.DepenseMapper;
import com.ewallet.wallet.service.mapper.RevenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ewallet.wallet.entities.Depense;
import com.ewallet.wallet.service.DepenseService;
import com.ewallet.wallet.service.dto.DepenseDto;

@RestController

public class DepenseController {

    @Autowired
    private DepenseService depenseService;

    @Autowired
    private DepenseMapper depenseMapper;

    public DepenseController(DepenseMapper depenseMapper) {
        this.depenseMapper = depenseMapper;

    }

    @PostMapping("/depenses")
    @ResponseBody
    public DepenseDto saveDepenses(@RequestBody DepenseDto depenseDto) {
        return depenseService.saveDepenses(depenseDto);
    }

    @GetMapping("/getDepenses")
    @ResponseBody

    public List<Depense> getAllDpenses() {
        return depenseService.getAllDepenses();
    }

    @PutMapping("/updateDepenses")

    public DepenseDto updateDepenses(@RequestBody DepenseDto depenseDto) {
        return depenseService.updateDepenses(depenseDto);
    }

    @DeleteMapping("/deleteDepenses/{id}")
    @ResponseBody
    public void deleteDepensesById(@PathVariable("id") Long idDepense) {
        depenseService.deleteDepensesById(idDepense);

    }

    @GetMapping("/mesDepenses")
    @ResponseBody

    public Depense getDepenses(@PathVariable("id") Long idDepense) {
        return depenseService.getDepenses(idDepense);

    }

    @GetMapping("/getLastDepenses")
    @ResponseBody

    public List<Depense> findLastDepenses() {
        return depenseService.findLastDepenses();
    }

    @GetMapping("/totalDepense")
    public Double getTotalDepenseAmount() {
        return depenseService.getTotalDepenseAmount();
    }

    @GetMapping("/getPaiementsPrevus")
    @ResponseBody

    public List<Depense> getPaiementsPrevus() {
        return depenseService.getPaiementsPrevus();
    }
}
