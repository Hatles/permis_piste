package com.polytech.permis_piste.dao;

import com.polytech.permis_piste.model.InscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by coren on 17/06/2017.
 */
public interface InscriptionDAO extends JpaRepository<InscriptionEntity, Integer> {

  //  @Query("from Inscription where apprenantByNumapprenant.numapprenant=:membreID and jeuByNumjeu.numjeu=:jeuID")
   // InscriptionDAO findInscriptionEntityByApprenantByNumapprenantAndNumjeu(@Param(value = "membreID") Integer membreID, @Param(value = "jeuID") Integer jeuID);
}