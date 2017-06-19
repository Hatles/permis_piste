package com.polytech.permis_piste.dao;

import com.polytech.permis_piste.model.ActionEntity;
import com.polytech.permis_piste.model.ObjectifEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by coren on 17/06/2017.
 */
public interface ActionDAO extends JpaRepository<ActionEntity, Integer> {

    List<ActionEntity> findActionEntitiesByObjectifsIs(ObjectifEntity objectifEntity);

    List<ActionEntity> findActionEntitiesByActNumactionIs(int actNumAction);

    @Query("select count(a) from ActionEntity a")
    int getNumber();
}
