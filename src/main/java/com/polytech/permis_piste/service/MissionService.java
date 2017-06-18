package com.polytech.permis_piste.service;

import com.polytech.permis_piste.dao.MissionDAO;
import com.polytech.permis_piste.model.MissionEntity;
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

    @PostConstruct
    protected void initialize() {
        save(new MissionEntity(1, 1, "Mission A"));
        save(new MissionEntity(2, 1, "Mission B"));
        save(new MissionEntity(3, 1, "Mission C"));
        save(new MissionEntity(4, 1, "Mission 3"));
        save(new MissionEntity(5, 2, "Mission A2"));
        save(new MissionEntity(6, 2, "Mission B2"));
        save(new MissionEntity(7, 2, "Mission C2"));
        save(new MissionEntity(8, 2, "Mission D2"));
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

    @Transactional
    public MissionEntity getById(int id) {
        return missionDAO.findOne(id);
    }

    @Transactional
    public List<MissionEntity> findAllByJeuId(int jeuID) {
        return missionDAO.findMissionEntitiesByJeuByNumjeu(jeuID);
    }


}
