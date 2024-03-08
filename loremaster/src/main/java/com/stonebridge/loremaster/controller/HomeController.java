package com.stonebridge.loremaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// Manage Home Pages
@Controller
public class HomeController {

    @RequestMapping(value = "/characters", method = RequestMethod.GET)
    public String showCharactersPage(ModelMap model) {
        return "characters";
    }

    @RequestMapping(value = "/sheets", method = RequestMethod.GET)
    public String showSheetsPage(ModelMap model) {
        return "sheets";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showCreatePage(ModelMap model) {
        return "create";
    }

    @RequestMapping(value = "/explore", method = RequestMethod.GET)
    public String showExplorePage(ModelMap model) {
        return "explore";
    }

}