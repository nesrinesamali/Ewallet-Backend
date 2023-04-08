package com.nesryne.wallet.service.mapper;

import org.mapstruct.Mapper;

import com.nesryne.wallet.entities.Depense;
import com.nesryne.wallet.service.dto.DepenseDto;


@Mapper(componentModel="spring",uses={})
public interface DepenseMapper  extends EntityMapper<DepenseDto,Depense> {
    
}

