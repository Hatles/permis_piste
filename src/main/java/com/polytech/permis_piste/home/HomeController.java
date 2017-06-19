package com.polytech.permis_piste.home;

import com.polytech.permis_piste.controller.DefaultController;
import com.polytech.permis_piste.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
class HomeController extends DefaultController{

	@Autowired
	private ApprenantService apprenantService;
	@Autowired
	private JeuService jeuService;
	@Autowired
	private MissionService missionService;
	@Autowired
	private ObjectifService objectifService;
	@Autowired
	private ActionService actionService;

	public HomeController() {
		super("home");
	}

	@ModelAttribute("module")
	String module() {
		return "home";
	}

//	@GetMapping("/")
//	String index(Principal principal) {
//		return principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
//	}

	@GetMapping("/")
	ModelAndView index(Principal principal) {
		return render(principal != null ? "homeSignedIn" : "homeNotSignedIn")
				.addObject("numberApprenants", apprenantService.getNumberApprenant())
				.addObject("numberJeux", jeuService.getNumber())
				.addObject("numberMissions", missionService.getNumber())
				.addObject("numberObjectifs", objectifService.getNumber())
				.addObject("numberActions", actionService.getNumber())
				;
	}
}
