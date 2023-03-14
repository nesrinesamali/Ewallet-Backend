package com.nesryne.wallet.service.mapper;

import org.mapstruct.Mapper;

import com.nesryne.wallet.entities.Depenses;
import com.nesryne.wallet.service.dto.DepensesDto;
@Mapper(componentModel="spring",uses={})
public interface DepensesMapper extends EntityMapper<DepensesDto,Depenses>{
    
}
