package com.polytech.permis_piste.dao;

import com.polytech.permis_piste.account.Account;
import com.polytech.permis_piste.model.ApprenantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by coren on 17/06/2017.
 */
public interface ApprenantDAO extends JpaRepository<ApprenantEntity, Integer> {
  /*  @Query("from Apprenant a left join fetch a.inscriptionsByNumapprenant WHERE a.id = (:id)")
    ApprenantDAO findByIdandInscription(@Param("id") Integer id);

    @Query("from Apprenant a where a.nomapprenant like concat('%', concat(:label, '%')) or a.prenomapprenant like concat('%', concat(:label, '%'))")
    List<ApprenantDAO> findByLabel(@Param("label") String label);*/
}