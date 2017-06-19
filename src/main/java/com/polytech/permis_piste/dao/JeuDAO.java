package com.polytech.permis_piste.dao;

import com.polytech.permis_piste.model.ApprenantEntity;
import com.polytech.permis_piste.model.JeuEntity;
import com.polytech.permis_piste.model.MissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by coren on 17/06/2017.
 */
public interface JeuDAO extends JpaRepository<JeuEntity, Integer> {
    JeuEntity findByLibellejeu(String lib);

    JeuEntity findJeuEntityByMissionsIs(MissionEntity missionEntity);

    List<JeuEntity> findJeuEntitiesByApprenantsIs(ApprenantEntity apprenantEntity);

    @Query("select count(a) from JeuEntity a")
    int getNumber();
}
