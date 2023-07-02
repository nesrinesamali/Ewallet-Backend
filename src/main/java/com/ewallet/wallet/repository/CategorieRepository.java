package com.ewallet.wallet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

import com.ewallet.wallet.entities.Categorie;
import com.ewallet.wallet.service.dto.CategorieDepenseDto;

import org.springframework.data.jpa.repository.Query;

// @Repository
public interface CategorieRepository extends JpaRepository<Categorie,Long>{
 
    @Query(value = "SELECT categorie.nom, SUM(depense.montant) AS somme_montant FROM categorie JOIN depense ON categorie.id_categorie = depense.category_id GROUP BY categorie.nom ", nativeQuery = true)

    List<Object[]> listDepenseByCategory();
   
   @Query(value = "SELECT categorie.nom FROM categorie JOIN depense ON categorie.id_categorie = depense.category_id GROUP BY categorie.nom, categorie.budget HAVING SUM(depense.montant) >= categorie.budget; ", nativeQuery = true)
    List<Object> listBudgetAtteint();



    
}
