package com.polytech.permis_piste.service;

import com.polytech.permis_piste.dao.*;
import com.polytech.permis_piste.model.ApprenantEntity;
import com.polytech.permis_piste.model.JeuEntity;
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
public class JeuService {

    @Autowired
    private JeuDAO jeuDAO;
    @Autowired
    private MissionDAO missionDAO;
    @Autowired
    private ObjectifDAO objectifDAO;
    @Autowired
    private ActionDAO actionDAO;
    @Autowired
    private ApprenantDAO apprenantDAO;

    @PostConstruct
    protected void initialize() {
        save(new JeuEntity(1, "Jeu n 1"));
        save(new JeuEntity(2, "Jeu n 2"));
    }

    @Transactional
    public void save(JeuEntity jeuEntity)
    {
        jeuDAO.save(jeuEntity);
    }

    @Transactional
    public void delete(JeuEntity jeuEntity)
    {
        jeuDAO.delete(jeuEntity);
    }

    @Transactional
    public List<JeuEntity> findAll()
    {
        List<JeuEntity> jeux = jeuDAO.findAll();
        return jeux;
    }

    public JeuEntity findByNumjeuAndFetchAll(Integer numJeu) {
        JeuEntity jeu = jeuDAO.findOne(numJeu);
        if (jeu == null) return null;

        jeu.setApprenants(apprenantDAO.findApprenantEntitiesByJeuxIs(jeu));
        jeu.setMissions(missionDAO.findMissionEntitiesByJeu_Numjeu(numJeu));
        jeu.getMissions().forEach(mission -> {
            mission.setObjectifs(objectifDAO.findObjectifEntitiesByMissionsIs(mission));
            mission.getObjectifs().forEach(objectif -> {
                objectif.setActions(actionDAO.findActionEntitiesByObjectifsIs(objectif));
            });
        });
        return jeu;
    }

    public JeuEntity getById(int id) {
        return jeuDAO.findOne(id);
    }

    public JeuEntity getByName(String name) {
        return jeuDAO.findByLibellejeu(name);
    }
}
