package com.polytech.permis_piste.controller;

import com.polytech.permis_piste.model.JeuEntity;
import com.polytech.permis_piste.service.JeuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by coren on 17/06/2017.
 */
@Controller
@RequestMapping("jeu")
public class JeuController {

    @Autowired
    private JeuService jeuService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String list(@PathVariable("id") int id, Model model) {
        model.addAttribute("jeu", this.jeuService.findByNumjeuAndFetchAll(id));
        return "jeu/index";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("jeux", this.jeuService.findAll());
        return "jeu/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @Secured({"ROLE_ADMIN"})
    public String add(Model model) {
        model.addAttribute("jeu", new JeuEntity());
        model.addAttribute("typeForm","Ajouter");
        return "jeu/form";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    @Secured({"ROLE_ADMIN"})
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("jeu", this.jeuService.getById(id));
        model.addAttribute("typeForm","Modifier");
        return "jeu/form";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @Secured({"ROLE_ADMIN"})
    public String delete(@PathVariable("id") int id, Model model) {
        this.jeuService.delete(this.jeuService.getById(id));
        return "redirect:/jeu/list";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @Secured({"ROLE_ADMIN"})
    public String save(@ModelAttribute("jeu") JeuEntity jeuEntity) {
        this.jeuService.save(jeuEntity);
        return "redirect:/jeu/list";
    }

}
