package com.stonebridge.loremaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;

import com.stonebridge.loremaster.model.*;
import com.stonebridge.loremaster.repository.*;
import com.stonebridge.loremaster.service.*;

@Controller
public class HomeController {

    @Autowired
    private LMSheetRepository sheetRepository;

    @Autowired
    private LMAttributeRepository attributeRepository;

    @Autowired
    private LMCharacterRepository characterRepository;

    @Autowired
    private LMCharacterAttributeRepository cAttributeRepository;

    // Display Characters Page
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