package com.nesryne.wallet.service.mapper;

import org.mapstruct.Mapper;

import com.nesryne.wallet.entities.Utilisateur;
import com.nesryne.wallet.service.dto.UtilisateurDto;

@Mapper(componentModel = "spring", uses = {})
public interface UtilisateurMapper extends EntityMapper<UtilisateurDto, Utilisateur> {
   

}
