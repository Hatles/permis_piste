package com.polytech.permis_piste.service;

import com.polytech.permis_piste.dao.JeuDAO;
import com.polytech.permis_piste.dao.MissionDAO;
import com.polytech.permis_piste.model.ApprenantEntity;
import com.polytech.permis_piste.model.JeuEntity;
import com.polytech.permis_piste.model.MissionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by coren on 17/06/2017.
 */
@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MissionService {

    @Autowired
    private MissionDAO missionDAO;

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
        List<MissionEntity> jeux = missionDAO.findAll();
        return jeux;
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
