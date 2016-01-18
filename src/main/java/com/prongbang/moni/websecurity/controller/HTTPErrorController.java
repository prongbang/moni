/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prongbang.moni.websecurity.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author prongbang
 */
@Controller
public class HTTPErrorController {

    @RequestMapping(value = "/404")
    public String handle404(Model model) {
        model.addAttribute("errorMessage", "404 Page Not Found");
        return "errors";
    }

    @RequestMapping(value = "/403")
    public String handle403(Model model) {

        //check if user is login
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
        }
        model.addAttribute("errorMessage", "You do not have permission to access this page");
        return "errors";
    }

    @RequestMapping(value = "/500")
    public String handle500(Model model) {
        model.addAttribute("errorMessage", "Error 500");
        return "errors";
    }

    @RequestMapping(value = "/503")
    public String handle503(Model model) {
        model.addAttribute("errorMessage", "Error 500");
        return "errors";
    }
}
