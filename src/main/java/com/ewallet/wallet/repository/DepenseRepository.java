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
    
    @Query(value = "SELECT * FROM depense where user_id= :idUser ORDER BY date ASC LIMIT 6", nativeQuery = true)
    List<Depense> findLastDepenses(Long idUser);
    
    @Query(value = "SELECT SUM(montant) FROM depense where user_id= :idUser", nativeQuery = true)
    Double getTotalDepenseAmount(Long idUser);
    
    @Query(value = "SELECT * FROM depense WHERE statut IS NOT NULL AND  user_id= :idUser", nativeQuery = true)
    List<Depense> getPaiementsPrevus(Long idUser);
    
    @Query(value = "SELECT montant, date FROM depense where user_id= :idUser", nativeQuery = true)
    List<Object[]> listmontantDateDepense(Long idUser);

    @Query("SELECT d FROM Depense d WHERE (d.statut='DONE' OR d.statut IS NULL) AND d.utilisateur.idUtilisateur=:idUser")
    List<Depense> findAllByIdUtilisateur(Long idUser);

    @Query(value="SELECT description  from depense where  user_id= :idUser and statut='TODO' and DATE_PART('day', AGE(date_prevue,CURRENT_DATE)) <=3;", nativeQuery = true)
    List<Object> notifPaiementPrevu(Long idUser);

    @Modifying
    @Query(value="UPDATE depense SET statut = 'DONE' WHERE id_depense=?;", nativeQuery = true)
    void doPaiementPrevu(Long id);
}

