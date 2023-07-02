package com.ewallet.wallet.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ewallet.wallet.entities.Categorie;
import com.ewallet.wallet.entities.Depense;
import com.ewallet.wallet.entities.Utilisateur;
import com.ewallet.wallet.repository.CategorieRepository;
import com.ewallet.wallet.repository.DepenseRepository;
import com.ewallet.wallet.repository.RevenuRepository;
import com.ewallet.wallet.repository.UtilisateurRepository;
import com.ewallet.wallet.service.dto.DepenseDto;
import com.ewallet.wallet.service.mapper.DepenseMapper;


@Service
public class DepenseServiceImpl implements DepenseService {
    @Autowired
    DepenseRepository depenseRepository;

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    CategorieRepository categorieRepository;

    @Autowired
    RevenuRepository revenuRepository;
       
    

    @Autowired
    DepenseMapper depenseMapper;
      public DepenseServiceImpl(DepenseMapper depenseMapper,DepenseRepository depenseRepository){
        this.depenseMapper=depenseMapper;
        this.depenseRepository=depenseRepository;
      }




@Override
public DepenseDto saveDepense(DepenseDto depenseDto) {
    Depense depense= DepenseDto.toEntity(depenseDto);

  
        Optional<Utilisateur> utilisateurOpt = utilisateurRepository.findById(depenseDto.getUserId());
        Utilisateur utilisateur = utilisateurOpt.isPresent()?utilisateurOpt.get():null;
        depense.setUtilisateur(utilisateur);
    

    Optional<Categorie> categorieOpt = categorieRepository.findById(depenseDto.getCategorieId());
        Categorie categorie = categorieOpt.isPresent()?categorieOpt.get():null;
        depense.setCategorie(categorie);
   
    

    depenseRepository.save(depense);
    return depenseMapper.toDto(depense);
    }



@Override
public void deleteDepensesById(Long idDepense) {
    depenseRepository.deleteById(idDepense);
}
@Override
public DepenseDto getDepense(Long idDepense) {
    return DepenseDto.fromEntity(depenseRepository.findById(idDepense).get());}
@Override
public List<Depense> getOwnDepenses(Authentication authentication) {
    System.out.println("auth " + authentication.getName());
    String email=authentication.getName();
    Utilisateur utilisateur=utilisateurRepository.findByEmail(email).get();
    return depenseRepository.findAllByUtilisateurIdUtilisateur(utilisateur.getIdUtilisateur());
}




@Override
public List<Depense> findLastDepenses() {
    return depenseRepository.findLastDepenses();
}
@Override
public Double getTotalDepenseAmount(Long idUser) {
    return depenseRepository.getTotalDepenseAmount(idUser);
}

@Override
public List<Depense> getPaiementsPrevus() {
    return depenseRepository.getPaiementsPrevus();
}   


@Override
public List<List<Object>>  chartDepenseRevenuData(){
    List<Object[]> depenses = depenseRepository.listmontantDateDepense();
    List<Object[]> revenus = revenuRepository.listmontantDateRevenu();
    List<List<Object>> result= new ArrayList<>() ;

    List<Object> dates = new ArrayList<>();
    List<Object>  montantdepList = new ArrayList<>();
    List<Object>  montantrevList = new ArrayList<>();


    for (Object[] dep : depenses){
        montantdepList.add( dep[0]);
        dates.add( dep[1]);
        montantrevList.add(0);
    }
    for (Object[] rev : revenus){
        montantrevList.add( rev[0]);
        dates.add( rev[1]);
        montantdepList.add(0);
    }
    result.add(dates);
    result.add(montantdepList);
    result.add(montantrevList);

    return result;


}



 @Transactional
@Override
public List<Object> notifPaiementPrevu() {
   return depenseRepository.notifPaiementPrevu();
}


@Override
public void doPaiementPrevu(Long id) {
    depenseRepository.doPaiementPrevu(id);
}

}
