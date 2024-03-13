package com.stonebridge.loremaster.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;

import com.stonebridge.loremaster.model.LMAttribute;
import com.stonebridge.loremaster.model.LMSheet;
import com.stonebridge.loremaster.model.DTO.AttributeDTO;
import com.stonebridge.loremaster.model.logical.Attribute;
import com.stonebridge.loremaster.repository.LMAttributeRepository;
import com.stonebridge.loremaster.repository.LMSheetRepository;
import com.stonebridge.loremaster.service.LMAttributeService;
import com.stonebridge.loremaster.service.LMSheetService;

import jakarta.servlet.http.HttpSession;

// Manage Character & Sheet Creation Pages
@Controller
public class CreateController {

    // #region Sheet Creation
    @Autowired
    private LMSheetRepository sheetRepository;
    @Autowired
    private LMAttributeRepository attributeRepository;

    // Display Sheet Editor
    @RequestMapping(value = "/createSheetAttributeEditor", method = RequestMethod.GET)
    public String showSheetAttributeEditor(HttpSession session) {
        List<Attribute> attributeList = new ArrayList<>();
        session.setAttribute("attributes", attributeList);
        return "createSheetAttributeEditor";
    }

    // #endregion

    @RequestMapping(value = "/createSheetFinalization", method = RequestMethod.GET)
    public String showSheetFinalization(HttpSession session) {
        return "createSheetFinalization";
    }

    @RequestMapping(value = "/saveAttributes", method = RequestMethod.POST)
    public String saveAttributes(@RequestBody List<AttributeDTO> attributeList, HttpSession session) {

        List<Attribute> attributes = new ArrayList<>();

        for (int i = 0; i < attributeList.size(); i++) {
            Attribute att = new Attribute(0l, attributeList.get(i).getName(), attributeList.get(i).getDesc());
            attributes.add(att);
        }

        // Apply Edited Attributes to Session
        session.setAttribute("attributes", attributes);

        return "/createSheetFinalization";
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/finalizeNewSheet", method = RequestMethod.POST)
    public String finalizeNewSheet(HttpSession session, String sheetTitle) {

        // Get the Sheet Service
        LMSheetService sheetService = new LMSheetService();
        LMAttributeService attributeService = new LMAttributeService();

        // Get this Sheet's ID
        Long nextSheetID = sheetService.GetNextSheetID(sheetRepository);

        // Construct Sheet to Save to DB
        LMSheet newSheet = new LMSheet();
        newSheet.setSheetName(sheetTitle);
        newSheet.setSheetUserID(0l); // TODO Pass in User ID from Session Variable

        // Save Sheet
        sheetService.saveNewSheet(sheetRepository, newSheet);

        // Save All of The Sheet's Attributes to DB
        List<Attribute> sheetAttributes = (List<Attribute>) session.getAttribute("attributes");
        for (int i = 0; i < sheetAttributes.size(); i++) {

            Attribute sheetAtt = sheetAttributes.get(i);

            LMAttribute newAttribute = new LMAttribute();
            newAttribute.setAttributeSheetID(nextSheetID);
            newAttribute.setAttributeName(sheetAtt.getAttributeName());
            newAttribute.setAttributeDesc(sheetAtt.getAttributeDesc());

            attributeService.saveNewAttribute(attributeRepository, newAttribute);

        }

        // Clear Attributes from Session
        session.removeAttribute("attributes");

        return "redirect:/sheets";
    }

    // #region Character Creation
    @RequestMapping(value = "/createCharacterSelectSheet", method = RequestMethod.GET)
    public String showCCSelectSheetPage(ModelMap model) {

        // TODO Get and Send all of the User's Sheets

        return "createCharacterSelectSheet";
    }

    // #endregion

}