package com.ewallet.wallet.service.mapper;

import org.mapstruct.Mapper;

import com.ewallet.wallet.entities.Depense;
import com.ewallet.wallet.service.dto.DepenseDto;


@Mapper(componentModel="spring",uses={})
public interface DepenseMapper  extends EntityMapper<DepenseDto,Depense> {
    
}

