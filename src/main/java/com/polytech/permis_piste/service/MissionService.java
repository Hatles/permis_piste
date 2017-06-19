package com.polytech.permis_piste.service;

import com.polytech.permis_piste.dao.JeuDAO;
import com.polytech.permis_piste.dao.MissionDAO;
import com.polytech.permis_piste.dao.ObjectifDAO;
import com.polytech.permis_piste.dao.ObtientDAO;
import com.polytech.permis_piste.model.*;
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
public class MissionService {

    @Autowired
    private MissionDAO missionDAO;

    @Autowired
    private ObtientDAO obtientDAO;

    @Autowired
    private ObjectifService objectifService;

    @Autowired
    private ObjectifDAO objectifDAO;

    @Autowired
    private JeuDAO jeuDAO;

    @PostConstruct
    protected void initialize() {
        save(new MissionEntity(1, 1, "Mission A")
                .addObjectif(objectifService.getById(1))
                .addObjectif(objectifService.getById(4))
                .addObjectif(objectifService.getById(5))
                .addObjectif(objectifService.getById(6))
        );
        save(new MissionEntity(2, 1, "Mission B")
                .addObjectif(objectifService.getById(2))
                .addObjectif(objectifService.getById(3))
                .addObjectif(objectifService.getById(5))
        );
        save(new MissionEntity(3, 1, "Mission C")
                .addObjectif(objectifService.getById(5))
                .addObjectif(objectifService.getById(7))
                .addObjectif(objectifService.getById(8))
        );
        save(new MissionEntity(4, 1, "Mission 3")
                .addObjectif(objectifService.getById(3))
                .addObjectif(objectifService.getById(4))
        );
        save(new MissionEntity(5, 2, "Mission A2")
                .addObjectif(objectifService.getById(1))
                .addObjectif(objectifService.getById(5))
                .addObjectif(objectifService.getById(7))
        );
        save(new MissionEntity(6, 2, "Mission B2")
                .addObjectif(objectifService.getById(2))
        );
        save(new MissionEntity(7, 2, "Mission C2")
                .addObjectif(objectifService.getById(7))
        );
        save(new MissionEntity(8, 2, "Mission D2")
                .addObjectif(objectifService.getById(5))
        );
    }

    @Transactional
    public void save(MissionEntity jeuEntity)
    {
        missionDAO.save(jeuEntity);
    }

    @Transactional
    public void delete(MissionEntity jeuEntity)
    {
        missionDAO.delete(jeuEntity);
    }

    @Transactional
    public List<MissionEntity> findAll()
    {
        List<MissionEntity> missionEntities = missionDAO.findAll();
        return missionEntities;
    }

    public MissionEntity findByNumMissionAndFetchAll(Integer numMission) {
        MissionEntity missionEntity = missionDAO.findOne(numMission);
        if (missionEntity == null) return null;
        missionEntity.setJeu(jeuDAO.findJeuEntityByMissionsIs(missionEntity));
        missionEntity.setObjectifs(objectifDAO.findObjectifEntitiesByMissionsIs(missionEntity));

        return missionEntity;
    }

    @Transactional
    public MissionEntity getById(int id) {
        return missionDAO.findOne(id);
    }

    @Transactional
    public int getNumber() {
        return missionDAO.getNumber();
    }

    @Transactional
    public Integer getNbObjectifsComplets(ApprenantEntity apprenantEntity, Integer numMission, JeuEntity jeuEntity) {
        MissionEntity missionEntity = findByNumMissionAndFetchAll(numMission);

        int val=0;
        for (ObjectifEntity objectifEntity : missionEntity.getObjectifs()) {
            boolean complete = true;
            for (ActionEntity actionEntity : objectifEntity.getActions()) {
                ObtientEntity obtientEntity = obtientDAO.findObtientEntitiesByApprenantIsAndActionIsAndJeuIs(apprenantEntity,actionEntity,jeuEntity);
                if(!(obtientEntity!=null)
                    complete=false;
            }
            if(complete)
                val++;
        }

        return val;
    }
}
