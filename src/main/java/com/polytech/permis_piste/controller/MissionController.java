package com.polytech.permis_piste.controller;

import com.polytech.permis_piste.model.MissionEntity;
import com.polytech.permis_piste.service.JeuService;
import com.polytech.permis_piste.service.MissionService;
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
 * Created by coren on 17/06/2017.
 */
@Controller
@RequestMapping("mission")
public class MissionController {

    @Autowired
    private MissionService missionService;
    @Autowired
    private JeuService jeuService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String list(@PathVariable("id") int missionID, Model model) {
        model.addAttribute("mission", this.missionService.findByNumMissionAndFetchAll(missionID));
        return "mission/index";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("missions", this.missionService.findAll());
        return "mission/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @Secured({"ROLE_ADMIN"})
    public String add(Model model) {
        model.addAttribute("mission", new MissionEntity());
        model.addAttribute("jeux", this.jeuService.findAll());
        model.addAttribute("typeForm","Ajouter");
        return "mission/form";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    @Secured({"ROLE_ADMIN"})
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("mission", this.missionService.getById(id));
        model.addAttribute("jeux", this.jeuService.findAll());
        model.addAttribute("typeForm","Modifier");
        return "mission/form";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @Secured({"ROLE_ADMIN"})
    public String delete(@PathVariable("id") int id, RedirectAttributes ra) {
        this.missionService.delete(this.missionService.getById(id));
        MessageHelper.addSuccessAttribute(ra, "mission.delete");
        return "redirect:/mission/list";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @Secured({"ROLE_ADMIN"})
    public String save(@ModelAttribute("mission") MissionEntity missionEntity, RedirectAttributes ra) {
        this.missionService.save(missionEntity);
        MessageHelper.addSuccessAttribute(ra, "mission.save");
        return "redirect:/mission/list";
    }
}
