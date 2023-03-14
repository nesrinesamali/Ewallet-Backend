package com.nesryne.wallet.service.mapper;

import org.mapstruct.Mapper;

import com.nesryne.wallet.entities.Revenu;
import com.nesryne.wallet.service.dto.RevenuDto;

@Mapper(componentModel = "spring", uses = {})
public interface RevenuMapper extends EntityMapper<RevenuDto, Revenu> {
    

}
