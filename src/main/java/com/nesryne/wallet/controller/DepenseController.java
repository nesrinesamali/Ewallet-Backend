package com.nesryne.wallet.controller;

import java.util.List;

import com.nesryne.wallet.service.mapper.DepenseMapper;
import com.nesryne.wallet.service.mapper.RevenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nesryne.wallet.entities.Depense;
import com.nesryne.wallet.service.DepenseService;
import com.nesryne.wallet.service.dto.DepenseDto;

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

    public List<Depense> getAllBudgets() {
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

    @GetMapping("/getDepense/{id}")
    @ResponseBody

    public Depense getDepenses(@PathVariable("id") Long idDepense) {
        return depenseService.getDepenses(idDepense);

    }
}
