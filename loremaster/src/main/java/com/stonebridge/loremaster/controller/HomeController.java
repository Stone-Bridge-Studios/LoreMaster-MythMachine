package com.stonebridge.loremaster.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stonebridge.loremaster.model.LMSheet;
import com.stonebridge.loremaster.repository.LMSheetRepository;

// Manage Home Pages
@Controller
public class HomeController {

    @Autowired
    private LMSheetRepository sheetRepository;

    @RequestMapping(value = "/characters", method = RequestMethod.GET)
    public String showCharactersPage(ModelMap model) {
        return "characters";
    }

    @RequestMapping(value = "/sheets", method = RequestMethod.GET)
    public String showSheetsPage(ModelMap model) {

        // Get All of the Logged in User's Character Sheets
        List<LMSheet> userSheets = sheetRepository.getUserSheets(0l); // TODO Pass in from session variable
        model.addAttribute("userSheets", userSheets);

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