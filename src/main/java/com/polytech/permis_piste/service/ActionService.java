package com.polytech.permis_piste.service;

import com.polytech.permis_piste.dao.ActionDAO;
import com.polytech.permis_piste.model.ActionEntity;
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
public class ActionService {

    @PostConstruct
    protected void initialize() {
        save(new ActionEntity(1, null, "Se mettre en tenue", 7));
        save(new ActionEntity(2, 1, "Préparation véhicule", 7));
        save(new ActionEntity(3, null, "Respect sécurité", 11));
        save(new ActionEntity(4, 3, "Effectuer manoeuvre", 7));
        save(new ActionEntity(5, null, "Emettre hypothÃ¨se", 12));
        save(new ActionEntity(6, 5, "Proposer solution", 7));
        save(new ActionEntity(7, 6, "Evaluation solution", 11));
        save(new ActionEntity(8, 7, "Effectuer solution", 10));
        save(new ActionEntity(9, null, "Accéder mécanique", 7));
        save(new ActionEntity(10, 9, "Vérifications mécanique", 9));
        save(new ActionEntity(11, 10, "Analyser panne(s)", 11));
        save(new ActionEntity(12, 10, "Effectuer niveaux", 10));
        save(new ActionEntity(13, null, "Réaction", 7));
        save(new ActionEntity(14, 13, "Action face au danger", 13));
        save(new ActionEntity(15, null, "Prise d'informations", 7));
        save(new ActionEntity(16, 15, "Placement", 12));
        save(new ActionEntity(17, 15, "Utilisation outils comm", 9));
        save(new ActionEntity(18, null, "Respect protocole comm", 15));
        save(new ActionEntity(19, null, "Travail rendu à temps", 13));
    }

    @Autowired
    private ActionDAO actionDAO;

    @Transactional
    public void save(ActionEntity actionEntity)
    {
        actionDAO.save(actionEntity);
    }

    @Transactional
    public void delete(ActionEntity actionEntity)
    {
        actionDAO.delete(actionEntity);
    }

    @Transactional
    public List<ActionEntity> findAll()
    {
        return actionDAO.findAll();
    }

    @Transactional
    public ActionEntity getById(int id) {
        return this.actionDAO.findOne(id);
    }
}
