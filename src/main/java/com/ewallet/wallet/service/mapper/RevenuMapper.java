package com.ewallet.wallet.service.mapper;

import org.mapstruct.Mapper;

import com.ewallet.wallet.entities.Revenu;
import com.ewallet.wallet.service.dto.RevenuDto;

@Mapper(componentModel = "spring", uses = {})
public interface RevenuMapper extends EntityMapper<RevenuDto, Revenu> {
    

}
