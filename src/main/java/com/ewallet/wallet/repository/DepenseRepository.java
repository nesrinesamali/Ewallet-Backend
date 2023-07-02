package com.ewallet.wallet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;

import com.ewallet.wallet.entities.Depense;

@Repository
@Transactional
public interface DepenseRepository extends JpaRepository<Depense,Long>{
    
    @Query(value = "SELECT * FROM depense ORDER BY date ASC LIMIT 6", nativeQuery = true)
    List<Depense> findLastDepenses();
    
    @Query(value = "SELECT SUM(montant) FROM depense where user_id= ?1", nativeQuery = true)
    Double getTotalDepenseAmount(Long idUser);
    
    @Query(value = "SELECT * FROM depense WHERE statut IS NOT NULL", nativeQuery = true)
    List<Depense> getPaiementsPrevus();
    
    @Query(value = "SELECT montant, date FROM depense", nativeQuery = true)
    List<Object[]> listmontantDateDepense();

    @Query(value = "SELECT * FROM depense  WHERE statut='DONE'OR statut is null AND user_id=?", nativeQuery = true)
    List<Depense> findAllByUtilisateurIdUtilisateur(Long id);

    @Query(value="SELECT description  from depense where statut='TODO' and DATE_PART('day', AGE(date_prevue,CURRENT_DATE)) <=3;", nativeQuery = true)
    List<Object> notifPaiementPrevu();

    @Modifying
    @Query(value="UPDATE depense SET statut = 'DONE' WHERE id_depense=?;", nativeQuery = true)
    void doPaiementPrevu(Long id);
}

