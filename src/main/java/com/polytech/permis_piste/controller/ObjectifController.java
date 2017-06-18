package com.polytech.permis_piste.controller;

import com.polytech.permis_piste.dao.ObjectifDAO;
import com.polytech.permis_piste.service.ObjectifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by coren on 18/06/2017.
 */
@Controller
@RequestMapping("objectif")
public class ObjectifController {

    @Autowired
    private ObjectifService objectifService;

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


}