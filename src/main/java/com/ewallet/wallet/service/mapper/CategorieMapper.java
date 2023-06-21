package com.ewallet.wallet.service.mapper;
import org.mapstruct.Mapper;

import com.ewallet.wallet.entities.Categorie;
import com.ewallet.wallet.service.dto.CategorieDto;

@Mapper(componentModel = "spring" ,uses={})
public interface CategorieMapper extends EntityMapper <CategorieDto,Categorie>  {
    
}






