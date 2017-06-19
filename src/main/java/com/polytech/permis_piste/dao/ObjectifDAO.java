package com.polytech.permis_piste.dao;

import com.polytech.permis_piste.model.ActionEntity;
import com.polytech.permis_piste.model.MissionEntity;
import com.polytech.permis_piste.model.ObjectifEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by coren on 17/06/2017.
 */
public interface ObjectifDAO extends JpaRepository<ObjectifEntity, Integer> {

    List<ObjectifEntity> findObjectifEntitiesByMissionsIs(MissionEntity missionEntity);

    List<ObjectifEntity> findObjectifEntitiesByActionsIs(ActionEntity numAction);

    @Query("select count(a) from ObjectifEntity a")
    int getNumber();
}
