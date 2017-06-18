package com.polytech.permis_piste.controller;

import com.polytech.permis_piste.model.ApprenantEntity;
import com.polytech.permis_piste.service.ActionService;
import com.polytech.permis_piste.service.ApprenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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


}
