package com.polytech.permis_piste.service;

import com.polytech.permis_piste.dao.ObtientDAO;
import com.polytech.permis_piste.model.ObtientEntity;
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
public class ScoreService {

    @Autowired
    private ObtientDAO obtientDAO;

    @Autowired
    private ApprenantService apprenantService;

    @Autowired
    private ActionService actionService;

    @PostConstruct
    protected void initialize() {
        save(new ObtientEntity(3, 3, 12));
        save(new ObtientEntity(3, 4, 8));
        save(new ObtientEntity(12, 3, 12));
        save(new ObtientEntity(12, 4, 18));
    }

    @Transactional
    public void save(ObtientEntity obtientEntity)
    {
        obtientDAO.save(obtientEntity);
    }

    @Transactional
    public void delete(ObtientEntity obtientEntity)
    {
        obtientDAO.delete(obtientEntity);
    }

    @Transactional
    public List<ObtientEntity> findAll()
    {
        List<ObtientEntity> obtientEntity = obtientDAO.findAll();
        return obtientEntity;
    }

    @Transactional
    public ObtientEntity getById(int id) {
        return obtientDAO.findOne(id);
    }
}

