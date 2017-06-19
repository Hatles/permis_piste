package com.polytech.permis_piste.service;

import com.polytech.permis_piste.dao.ActionDAO;
import com.polytech.permis_piste.dao.MissionDAO;
import com.polytech.permis_piste.dao.ObjectifDAO;
import com.polytech.permis_piste.model.ObjectifEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by coren on 17/06/2017.
 */
@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)

public class ObjectifService {
    @Autowired
    private ObjectifDAO objectifDAO;
    @Autowired
    private ActionDAO actionDAO;
    @Autowired
    private MissionDAO missionDAO;
    @PostConstruct
    protected void initialize() {
        save(new ObjectifEntity(1, "Réussir manoeuvre"));
        save(new ObjectifEntity(2, "Analyse des problèmes"));
        save(new ObjectifEntity(3, "Vérifier mécanique"));
        save(new ObjectifEntity(4, "Réagir au danger"));
        save(new ObjectifEntity(5, "Prise de poste correcte"));
        save(new ObjectifEntity(6, "Placement sur la voie"));
        save(new ObjectifEntity(7, "Interaction avec pilote"));
        save(new ObjectifEntity(8, "Respect délai"));
    }

    public ObjectifEntity findByNumobjectifAndFetchAll(Integer numObjectif) {
        ObjectifEntity objectifEntity = objectifDAO.findOne(numObjectif);
        if (objectifEntity == null) return null;

        objectifEntity.setActions(actionDAO.findActionEntitiesByObjectifsIs(objectifEntity));
        objectifEntity.setMissions(missionDAO.findMissionEntitiesByObjectifsIs(objectifEntity));

        return objectifEntity;
    }

    @Transactional
    public void save(ObjectifEntity objectifEntity)
    {
        objectifDAO.save(objectifEntity);
    }

    @Transactional
    public void delete(ObjectifEntity objectifEntity)
    {
        objectifDAO.delete(objectifEntity);
    }

    @Transactional
    public List<ObjectifEntity> findAll()
    {
        List<ObjectifEntity> objectifEntities = objectifDAO.findAll();
        return objectifEntities;
    }

    @Transactional
    public ObjectifEntity getById(int id) {
        return objectifDAO.findOne(id);
    }

    @Transactional
    public int getNumber() {
        return objectifDAO.getNumber();
    }
}
