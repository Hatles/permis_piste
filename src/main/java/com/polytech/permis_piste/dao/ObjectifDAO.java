package com.polytech.permis_piste.dao;

import com.polytech.permis_piste.model.ActionEntity;
import com.polytech.permis_piste.model.MissionEntity;
import com.polytech.permis_piste.model.ObjectifEntity;
import com.polytech.permis_piste.model.ObtientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.util.Collection;
import java.util.List;

/**
 * Created by coren on 17/06/2017.
 */
public interface ObjectifDAO extends JpaRepository<ObjectifEntity, Integer> {

    List<ObjectifEntity> findObjectifEntitiesByMissionsIs(MissionEntity missionEntity);

    List<ObjectifEntity> findObjectifEntitiesByActionsIs(ActionEntity numAction);
}
