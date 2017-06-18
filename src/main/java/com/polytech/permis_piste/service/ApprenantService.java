package com.polytech.permis_piste.service;

import com.polytech.permis_piste.dao.ApprenantDAO;
import com.polytech.permis_piste.dao.JeuDAO;
import com.polytech.permis_piste.model.ApprenantEntity;
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
public class ApprenantService {

    @Autowired
    private ApprenantDAO apprenantDAO;

    @Transactional
    public void save(ApprenantEntity apprenantEntity)
    {
        apprenantDAO.save(apprenantEntity);
    }

    @Transactional
    public void delete(ApprenantEntity apprenantEntity)
    {
        apprenantDAO.delete(apprenantEntity);
    }

    @Transactional
    public List<ApprenantEntity> findAll()
    {
        return apprenantDAO.findAll();
    }

    @Transactional
    public ApprenantEntity getById(int id) {
        return this.apprenantDAO.findOne(id);
    }
}
