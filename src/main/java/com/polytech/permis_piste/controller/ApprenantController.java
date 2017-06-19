package com.polytech.permis_piste.controller;

import com.polytech.permis_piste.model.*;
import com.polytech.permis_piste.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by coren on 17/06/2017.
 */
@Controller
@RequestMapping("apprenant")
public class ApprenantController {

    @Autowired
    private ApprenantService apprenantService;
    @Autowired
    private ActionService actionService;
    @Autowired
    private JeuService jeuService;
    @Autowired
    private ScoreService obtientService;
    @Autowired
    private ObjectifService objectifService;
    @Autowired
    private MissionService missionService;

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public String currentin(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        ApprenantEntity apprenantEntity = apprenantService.findByNomAndFetchAll(username);

        model.addAttribute("apprenant", this.apprenantService.findByNumapprenantAndFetchAll(apprenantEntity.getNumapprenant()));
        model.addAttribute("jeux", this.jeuService.findAllWhereApprenantNotInscrit(apprenantEntity));
        return "apprenant/index";
    }

    @RequestMapping(value = "/inscrire/{jeuid}", method = RequestMethod.GET)
    public String inscrire(@PathVariable("jeuid") int jeuid, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        ApprenantEntity apprenantEntity = apprenantService.findByNomAndFetchAll(username);

        apprenantEntity.addJeu(jeuService.getById(jeuid));
        apprenantService.save(apprenantEntity);
        return "redirect:/apprenant/current";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("apprenants", this.apprenantService.findAll());
        return "apprenant/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    @Secured({"ROLE_ADMIN"})
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("apprenant", this.apprenantService.getById(id));
        model.addAttribute("typeForm","Modifier");
        return "apprenant/form";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @Secured({"ROLE_ADMIN"})
    public String delete(@PathVariable("id") int id, Model model) {
        this.apprenantService.delete(this.apprenantService.getById(id));
        return "redirect:/apprenant/list";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @Secured({"ROLE_ADMIN"})
    public String save(@ModelAttribute("apprenant") ApprenantEntity apprenantEntity) {
        this.apprenantService.save(apprenantEntity);
        return "redirect:/apprenant/list";
    }

    @RequestMapping(value = "/jeu/{jeuid}", method = RequestMethod.GET)
    public String jeu(@PathVariable("jeuid") int jeuid, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        ApprenantEntity apprenantEntity = apprenantService.findByNomAndFetchAll(username);

        if(!apprenantEntity.getJeux().stream().anyMatch(jeuEntity -> jeuEntity.getNumjeu()==jeuid))
            return "redirect:/jeu/list";

        JeuEntity jeuEntity = jeuService.findByNumjeuAndFetchAll(jeuid);
        for (MissionEntity missionEntity : jeuEntity.getMissions()) {
            missionEntity.setNbObjectifsComplets(missionService.getNbObjectifsComplets(apprenantEntity,missionEntity.getNummission(),jeuEntity));
            for (ObjectifEntity objectifEntity : missionEntity.getObjectifs()) {
                objectifEntity.setNbActionsReussis(objectifService.getNbActionsReussies(apprenantEntity,objectifEntity.getNumobjectif(),jeuEntity));
            }
        }

        model.addAttribute("jeu", jeuEntity);

        return "apprenant/jeu";
    }

     @RequestMapping(value = "/jeu/{jeuid}/{missionid}/{objectifid}", method = RequestMethod.GET)
    public String objectif(@PathVariable("jeuid") int jeuid,@PathVariable("missionid") int missionid,@PathVariable("objectifid") int objectifid, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        ApprenantEntity apprenantEntity = apprenantService.findByNomAndFetchAll(username);

        ObjectifEntity objectifEntity = objectifService.findByNumobjectifAndFetchAll(objectifid);
        objectifEntity.getActions().forEach(
                actionEntity -> {
                    List<ObtientEntity> obtientEntities = new ArrayList<ObtientEntity>();
                    ObtientEntity obtientEntity = obtientService.findObtientEntityByApprenantNumAndActionNumAndJeuNumAndFetchAll(apprenantEntity.getNumapprenant(),actionEntity.getNumaction(),jeuid);
                    if(obtientEntity!=null)
                        obtientEntities.add(obtientEntity);
                    actionEntity.setScores(obtientEntities);
                    actionEntity.setActions(actionService.findActionEntitiesByActNumactionIs(actionEntity.getNumaction()));

                        actionEntity.setCanDo(true);
                        actionEntity.getActions().forEach(actionEntity1 -> {
                            ObtientEntity obtientEntity1 = obtientService.findObtientEntityByApprenantNumAndActionNumAndJeuNumAndFetchAll(apprenantEntity.getNumapprenant(), actionEntity1.getNumaction(), jeuid);
                            if (obtientEntity1 == null) {
                                actionEntity.setCanDo(false);
                                return;
                            }
                        });
                    if(obtientEntity!=null && actionEntity.getCanDo())
                        actionEntity.setCanDo(false);
                }
        );

        model.addAttribute("objectif", objectifEntity);
        model.addAttribute("jeuid", jeuid);
        model.addAttribute("missionid", missionid);
        model.addAttribute("objectifid", objectifid);

        return "apprenant/objectif";
    }

}
