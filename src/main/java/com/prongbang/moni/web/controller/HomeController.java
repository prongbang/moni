package com.prongbang.moni.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author prongbang
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String init(ModelMap model) {

        return "login";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(ModelMap model) {

        model.addAttribute("message", "prongbang");

        return "index";
    }

}
