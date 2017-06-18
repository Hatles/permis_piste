package com.polytech.permis_piste.controller;

import com.polytech.permis_piste.model.ApprenantEntity;
import com.polytech.permis_piste.service.ApprenantService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("apprenant")
public class ApprenantController {

    @Autowired
    private ApprenantService apprenantService;

    /*@ModelAttribute("module")
    String module() {
        return "apprenant";
    }*/

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("apprenants", this.apprenantService.findAll());
        return "apprenant/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("apprenant", this.apprenantService.getById(id));
        model.addAttribute("typeForm","Modifier");
        return "apprenant/form";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id, Model model) {
        this.apprenantService.delete(this.apprenantService.getById(id));
        return "redirect:/apprenant/list";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("apprenant") ApprenantEntity apprenantEntity) {
        this.apprenantService.save(apprenantEntity);
        return "redirect:/apprenant/list";
    }

}
