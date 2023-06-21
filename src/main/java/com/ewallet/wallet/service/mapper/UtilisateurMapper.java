package com.ewallet.wallet.service.mapper;

import org.mapstruct.Mapper;

import com.ewallet.wallet.entities.Utilisateur;
import com.ewallet.wallet.service.dto.UtilisateurDto;

@Mapper(componentModel = "spring", uses = {})
public interface UtilisateurMapper extends EntityMapper<UtilisateurDto, Utilisateur> {
   

}
