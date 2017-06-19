package com.polytech.permis_piste.signup;

import com.polytech.permis_piste.account.Account;
import com.polytech.permis_piste.account.AccountService;
import com.polytech.permis_piste.support.web.Ajax;
import com.polytech.permis_piste.support.web.MessageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
class SignupController {

	private static final String SIGNUP_VIEW_NAME = "signup/signup";
	private static final String SIGNUP_FORM_NAME = "signup/signupForm";

	@Autowired
	private AccountService accountService;

	@GetMapping("signup")
	String signup(Model model, @RequestHeader(value = "X-Requested-With", required = false) String requestedWith) {
		model.addAttribute("signupForm", new SignupForm());
		if (Ajax.isAjaxRequest(requestedWith)) {
			return SIGNUP_FORM_NAME;
		}
		return SIGNUP_VIEW_NAME;
	}

	@PostMapping("signup")
	String signup(@Valid @ModelAttribute SignupForm signupForm, Errors errors, Model model, RedirectAttributes ra) {
		if (errors.hasErrors()) {
			model.addAttribute("signupForm", new SignupForm());
			return SIGNUP_VIEW_NAME;
		}
		System.out.println("dqzd");
		Account account = accountService.save(signupForm.createAccount());
		accountService.signin(account);
        // see /WEB-INF/i18n/messages.properties and /WEB-INF/views/homeSignedIn.html
        MessageHelper.addSuccessAttribute(ra, "signup.success");
		return "redirect:/";
	}
}
