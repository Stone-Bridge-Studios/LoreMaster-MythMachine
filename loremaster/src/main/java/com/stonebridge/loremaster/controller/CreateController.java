package com.stonebridge.loremaster.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stonebridge.loremaster.model.logical.Attribute;

// Manage Character & Sheet Creation Pages
@Controller
public class CreateController {

    // #region Sheet Creation

    @RequestMapping(value = "/createSheetAttributeEditor", method = RequestMethod.GET)
    public String showSheetAttributeEditor(ModelMap model) {

        // Create a Test List of Attributes
        List<Attribute> attributeList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Attribute att = new Attribute();
            att.setAttributeName("Attribute Number " + Integer.toString(i));
            attributeList.add(att);
        }

        model.addAttribute("sheetAttributes", attributeList);

        return "createSheetAttributeEditor";
    }

    // #endregion

    // #region Character Creation
    @RequestMapping(value = "/createCharacterSelectSheet", method = RequestMethod.GET)
    public String showCCSelectSheetPage(ModelMap model) {

        // TODO Get and Send all of the User's Sheets

        return "createCharacterSelectSheet";
    }

    // #endregion

}