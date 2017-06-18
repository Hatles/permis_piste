package com.polytech.permis_piste.service;

import com.polytech.permis_piste.dao.JeuDAO;
import com.polytech.permis_piste.dao.MissionDAO;
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

    public JeuEntity getById(int id) {
        return jeuDAO.findOne(id);
    }
}
