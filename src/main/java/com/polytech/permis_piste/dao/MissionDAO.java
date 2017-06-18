package com.polytech.permis_piste.dao;

import com.polytech.permis_piste.account.Account;
import com.polytech.permis_piste.model.JeuEntity;
import com.polytech.permis_piste.model.MissionEntity;
import com.polytech.permis_piste.model.ObjectifEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by coren on 17/06/2017.
 */
public interface MissionDAO extends JpaRepository<MissionEntity, Integer> {

    //@Query("select m from MissionEntity m where m.numjeu=:jeuID")
    List<MissionEntity> findMissionEntitiesByJeu_Numjeu(@Param("jeuID") Integer jeuID);

    List<MissionEntity> findMissionEntitiesByObjectifsIs(ObjectifEntity objectifEntity);
}