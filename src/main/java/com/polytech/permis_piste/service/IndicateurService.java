package com.polytech.permis_piste.service;

import com.polytech.permis_piste.dao.IndicateurDAO;
import com.polytech.permis_piste.model.IndicateurEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by kifkif on 18/06/2017.
 */
@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class IndicateurService {

    @Autowired
    private ObjectifService objectifService;

    @PostConstruct
    protected void initialize() {
        save(new IndicateurEntity(1, 1, 1));
        save(new IndicateurEntity(2, 2, 2));
        save(new IndicateurEntity(3, 3, 5));
        save(new IndicateurEntity(4, 4, 4));
        save(new IndicateurEntity(5, 5, 1));
        save(new IndicateurEntity(6, 6, 2));
        save(new IndicateurEntity(7, 7, 3));
        save(new IndicateurEntity(8, 8, 2));
        save(new IndicateurEntity(9, 9, 1));
        save(new IndicateurEntity(10, 10, 2));
        save(new IndicateurEntity(11, 11, 3));
        save(new IndicateurEntity(12, 12, 1));
        save(new IndicateurEntity(13, 13, 1));
        save(new IndicateurEntity(14, 14, 3));
        save(new IndicateurEntity(15, 15, 1));
        save(new IndicateurEntity(16, 16, 2));
        save(new IndicateurEntity(17, 17, 1));
        save(new IndicateurEntity(18, 18, 5));
        save(new IndicateurEntity(19, 19, 1));
    }

    @Autowired
    private IndicateurDAO indicateurDAO;

    @Transactional
    public void save(IndicateurEntity indicateurEntity)
    {
        indicateurDAO.save(indicateurEntity);
    }

    @Transactional
    public void delete(IndicateurEntity indicateurEntity)
    {
        indicateurDAO.delete(indicateurEntity);
    }

    @Transactional
    public List<IndicateurEntity> findAll()
    {
        List<IndicateurEntity> indicateurEntities = indicateurDAO.findAll();
        return indicateurEntities;
    }

    public IndicateurEntity getById(int id) {
        return indicateurDAO.findOne(id);
    }
}