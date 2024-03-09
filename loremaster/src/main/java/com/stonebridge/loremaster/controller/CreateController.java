package com.stonebridge.loremaster.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stonebridge.loremaster.model.logical.Attribute;

import jakarta.servlet.http.HttpSession;

// Manage Character & Sheet Creation Pages
@Controller
public class CreateController {

    // #region Sheet Creation

    // Display Sheet Editor
    @RequestMapping(value = "/createSheetAttributeEditor", method = RequestMethod.GET)
    public String showSheetAttributeEditor(HttpSession session) {

        // Create Attribute Retrieval Flag
        String reload = (String) session.getAttribute("reloadAttributes");

        if (reload == null) {
            // Create a Test List of Attributes
            List<Attribute> attributeList = new ArrayList<>();
            session.setAttribute("attributes", attributeList);
        }

        return "createSheetAttributeEditor";
    }

    // #endregion
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/addNewAttribute", method = RequestMethod.POST)
    public String addNewAttribute(HttpSession session) {

        // Get Current Attribute List
        List<Attribute> attributeList = (List<Attribute>) session.getAttribute("attributes");

        // Add a new attribute
        Attribute att = new Attribute();
        att.setAttributeName("New Attribute");
        attributeList.add(att);

        session.setAttribute("attributes", attributeList);
        session.setAttribute("reloadAttributes", "false");

        return "redirect:/createSheetAttributeEditor";
    }

    // #region Character Creation
    @RequestMapping(value = "/createCharacterSelectSheet", method = RequestMethod.GET)
    public String showCCSelectSheetPage(ModelMap model) {

        // TODO Get and Send all of the User's Sheets

        return "createCharacterSelectSheet";
    }

    // #endregion

}