package com.nesryne.wallet.service.mapper;

import org.mapstruct.Mapper;

import com.nesryne.wallet.entities.Categories;
import com.nesryne.wallet.service.dto.CategoriesDto;
@Mapper(componentModel = "spring" ,uses={})
public interface CategoriesMapper extends EntityMapper <CategoriesDto,Categories> {
    
}
