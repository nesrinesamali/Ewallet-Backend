package com.nesryne.wallet.service.mapper;

import org.mapstruct.Mapper;

import com.nesryne.wallet.entities.Budget;
import com.nesryne.wallet.service.dto.BudgetDto;
@Mapper(componentModel = "spring" ,uses={})
public interface BudgetMapper extends EntityMapper <BudgetDto,Budget> {
    
}
