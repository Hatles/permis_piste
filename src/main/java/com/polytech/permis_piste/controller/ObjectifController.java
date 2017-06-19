package com.polytech.permis_piste.controller;

import com.polytech.permis_piste.model.ObjectifEntity;
import com.polytech.permis_piste.service.MissionService;
import com.polytech.permis_piste.service.ObjectifService;
import com.polytech.permis_piste.support.web.MessageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by coren on 18/06/2017.
 */
@Controller
@RequestMapping("objectif")
public class ObjectifController {

    @Autowired
    private ObjectifService objectifService;

    @Autowired
    private MissionService missionService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String list(@PathVariable("id") int id, Model model) {
        model.addAttribute("objectif", this.objectifService.findByNumobjectifAndFetchAll(id));
        return "objectif/index";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("objectifs", this.objectifService.findAll());
        return "objectif/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @Secured({"ROLE_ADMIN"})
    public String add(Model model) {
        model.addAttribute("objectif", new ObjectifEntity());
//        model.addAttribute("missions", this.missionService.findAll());
        model.addAttribute("typeForm","Ajouter");
        return "objectif/form";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    @Secured({"ROLE_ADMIN"})
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("objectif", this.objectifService.getById(id));
//        model.addAttribute("missions", this.missionService.findAll());
        model.addAttribute("typeForm","Modifier");
        return "objectif/form";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @Secured({"ROLE_ADMIN"})
    public String delete(@PathVariable("id") int id, RedirectAttributes ra) {
        this.objectifService.delete(this.objectifService.getById(id));
        MessageHelper.addSuccessAttribute(ra, "mission.delete");
        return "redirect:/objectif/list";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @Secured({"ROLE_ADMIN"})
    public String save(@ModelAttribute("mission") ObjectifEntity objectifEntity, RedirectAttributes ra) {
        this.objectifService.save(objectifEntity);
        MessageHelper.addSuccessAttribute(ra, "mission.save");
        return "redirect:/objectif/list";
    }
}