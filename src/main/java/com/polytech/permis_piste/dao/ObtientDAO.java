package com.polytech.permis_piste.dao;

import com.polytech.permis_piste.model.ActionEntity;
import com.polytech.permis_piste.model.ApprenantEntity;
import com.polytech.permis_piste.model.JeuEntity;
import com.polytech.permis_piste.model.ObtientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by coren on 17/06/2017.
 */
public interface ObtientDAO extends JpaRepository<ObtientEntity, Integer> {

    List<ObtientEntity> findObtientEntitiesByApprenantIs(ApprenantEntity apprenantEntity);

    List<ObtientEntity> findObtientEntitiesByActionIs(ActionEntity actionEntity);

    ObtientEntity findObtientEntitiesByApprenantIsAndActionIsAndJeuIs(ApprenantEntity apprenantEntity, ActionEntity actionEntity, JeuEntity jeuEntity);
}
