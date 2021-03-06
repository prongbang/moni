package com.prongbang.moni.websecurity.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author prongbang
 */
@Controller
@RequestMapping("/")
public class SecurityController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView init(ModelMap model) {
        
        // Check user logged in
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {

            return new ModelAndView("forward:/home");
        }

        return new ModelAndView("forward:/login");
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error, 
            @RequestParam(value = "logout", required = false) String logout,
            @RequestParam(value = "expired", required = false) String expired
    ) {

        ModelAndView model = new ModelAndView();
        
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        
        if (expired != null) {
            model.addObject("expired", "Session expired!");
        }

        model.setViewName("login");

        return model;

    }

}
