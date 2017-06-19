package com.polytech.permis_piste.controller;

import com.polytech.permis_piste.model.ActionEntity;
import com.polytech.permis_piste.service.ActionService;
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
@RequestMapping("action")
public class ActionController {

    @Autowired
    private ActionService actionService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String list(@PathVariable("id") int id, Model model) {
        model.addAttribute("action", this.actionService.findByNumActionAndFetchAll(id));
        return "action/index";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("actions", this.actionService.findAll());
        return "action/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @Secured({"ROLE_ADMIN"})
    public String add(Model model) {
        model.addAttribute("action", new ActionEntity());
        model.addAttribute("actions", this.actionService.findAll());
        model.addAttribute("typeForm","Ajouter");
        return "action/form";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    @Secured({"ROLE_ADMIN"})
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("action", this.actionService.getById(id));
        model.addAttribute("actions", this.actionService.findAll());
        model.addAttribute("typeForm","Modifier");
        return "action/form";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @Secured({"ROLE_ADMIN"})
    public String delete(@PathVariable("id") int id, RedirectAttributes ra) {
        this.actionService.delete(this.actionService.getById(id));
        MessageHelper.addSuccessAttribute(ra, "mission.delete");
        return "redirect:/action/list";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @Secured({"ROLE_ADMIN"})
    public String save(@ModelAttribute("mission") ActionEntity actionEntity, RedirectAttributes ra) {
        this.actionService.save(actionEntity);
        MessageHelper.addSuccessAttribute(ra, "mission.save");
        return "redirect:/action/list";
    }
}
