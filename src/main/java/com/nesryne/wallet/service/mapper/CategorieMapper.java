package com.nesryne.wallet.service.mapper;
import org.mapstruct.Mapper;

import com.nesryne.wallet.entities.Categorie;
import com.nesryne.wallet.service.dto.CategorieDto;

@Mapper(componentModel = "spring" ,uses={})
public interface CategorieMapper extends EntityMapper <CategorieDto,Categorie>  {
    
}






