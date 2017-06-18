package com.polytech.permis_piste.service;

import com.polytech.permis_piste.account.Account;
import com.polytech.permis_piste.account.AccountRepository;
import com.polytech.permis_piste.account.AccountService;
import com.polytech.permis_piste.dao.ApprenantDAO;
import com.polytech.permis_piste.model.ApprenantEntity;
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
public class ApprenantService {

    @PostConstruct
    protected void initialize()
    {
        save(new ApprenantEntity(1, "Caron", "Antoine"));
        save(new ApprenantEntity(2, "Chauslende", "Adrien"));
        save(new ApprenantEntity(3, "Galdeano", "Alexandre"));
        save(new ApprenantEntity(4, "Reynaud", "Pierre"));
        save(new ApprenantEntity(11, "Premilieu", "Laura"));
        save(new ApprenantEntity(12, "Fagno", "Corinne"));
        save(new ApprenantEntity(13, "Rodarie", "Dimitri"));
        save(new ApprenantEntity(14, "Ferjani", "Gael"));
    }

    @Autowired
    private ApprenantDAO apprenantDAO;

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public ApprenantEntity save(ApprenantEntity apprenantEntity)
    {
        return apprenantDAO.save(apprenantEntity);
    }

    @Transactional
    public void delete(ApprenantEntity apprenantEntity)
    {
        accountRepository.deleteAccountByApprenant(apprenantEntity);
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
