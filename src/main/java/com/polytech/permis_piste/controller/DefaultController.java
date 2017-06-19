package com.polytech.permis_piste.controller;

import com.polytech.permis_piste.account.Account;
import com.polytech.permis_piste.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kifkif on 19/06/2017.
 */
public abstract class DefaultController {
    private String baseUrl;

    @Autowired
    private AccountRepository accountRepository;

    public DefaultController(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    protected ModelAndView render(String view, Map<String, Object> models)
    {
        Map<String, Object> models_ = getDefaultModels();
        models_.putAll(models);
        return new ModelAndView(String.format("%s/%s", baseUrl, view), models_);
    }

    protected ModelAndView render(String view, String modelName, Object model)
    {
        Map<String, Object> models = getDefaultModels();
        models.put(modelName, model);
        return new ModelAndView(String.format("%s/%s", baseUrl, view), modelName, models);
    }

    protected ModelAndView render(String view)
    {
        return new ModelAndView(String.format("%s/%s", baseUrl, view), getDefaultModels());
    }

    private Map<String, Object> getDefaultModels()
    {
        Map<String, Object> models = new HashMap<>();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            Account account = accountRepository.findOneByEmail(currentUserName);
            models.put("account", account);
        }

        return models;
    }
}
