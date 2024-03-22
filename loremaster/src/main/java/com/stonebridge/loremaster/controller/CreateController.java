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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpSession;

// Manage Character & Sheet Creation Pages
@Controller
public class CreateController {

    // #region Sheet Creation
    @Autowired
    private LMSheetRepository sheetRepository;
    @Autowired
    private LMAttributeRepository attributeRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(value = "/createSheetAttributeEditor", method = RequestMethod.GET)
    public String showSheetAttributeEditor(HttpSession session) {
        return "createSheetAttributeEditor";
    }

    // Creating A New Sheet
    @RequestMapping(value = "/createNewSheet", method = RequestMethod.GET)
    public String createNewSheet(HttpSession session) {
        session.removeAttribute("editAttributes");

        // Set Target Sheet ID to -1 (Non-existing sheet)
        session.setAttribute("sheetTargetID", -1l);

        // Store Sheet's Current Name (Empty String)
        session.setAttribute("sheetTitle", "New Sheet");

        return "createSheetAttributeEditor";
    }

    // Editing Existing Sheets
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/editExistingSheet", method = RequestMethod.POST)
    public String editExistingSheet(@RequestBody Long sheetID, HttpSession session) throws JsonProcessingException {

        // System.out.println("The ID is " + Long.toString(sheetID));

        // Get Selected Sheet's Existing Attributes
        List<LMAttribute> existingAttributes = attributeRepository.getSheetAttributes(sheetID);

        // Convert to Editable Attribute Objects
        @SuppressWarnings("rawtypes")
        List<AttributeDTO> attDTOs = new ArrayList();
        for (int i = 0; i < existingAttributes.size(); i++) {
            LMAttribute att = existingAttributes.get(i);
            attDTOs.add(
                    new AttributeDTO(att.getAttributeID().toString(), att.getAttributeName(), att.getAttributeDesc()));
        }

        // Convert the list to JSON string
        String jsonAttributes = objectMapper.writeValueAsString(attDTOs);

        // Attach Existing Attributes to Session
        session.setAttribute("editAttributes", jsonAttributes);

        // Set Target Sheet ID to the existing Sheet's ID
        session.setAttribute("sheetTargetID", sheetID);

        // Store Sheet's Current Name (Empty String)
        session.setAttribute("sheetTitle", sheetRepository.getSheetName(sheetID));

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
            Attribute att = new Attribute(0l, Long.parseLong(attributeList.get(i).getAttributeID()),
                    attributeList.get(i).getName(),
                    attributeList.get(i).getDesc());
            attributes.add(att);
        }

        // Apply Edited Attributes to Session
        session.setAttribute("attributes", attributes);

        return "/createSheetFinalization";
    }

    // TODO Divide this into smaller methods
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/finalizeNewSheet", method = RequestMethod.POST)
    public String finalizeNewSheet(HttpSession session, String sheetTitle) {

        // Get the Sheet Service
        LMSheetService sheetService = new LMSheetService();
        LMAttributeService attributeService = new LMAttributeService();

        Long sheetTargetID = (Long) session.getAttribute("sheetTargetID");

        if (sheetTargetID != -1) { // Editing an Existing Sheet

            // Update Sheet Title
            sheetRepository.updateSheetName(sheetTargetID, sheetTitle);

            // Get list of edited attributes
            List<Attribute> sheetAttributes = (List<Attribute>) session.getAttribute("attributes");

            // Get list of currently saved attributes of that sheet
            List<LMAttribute> currentAttributes = attributeRepository.getSheetAttributes(sheetTargetID);

            // Delete Removed Attributes
            for (int i = 0; i < currentAttributes.size(); i++) {
                Long currentAttID = currentAttributes.get(i).getAttributeID();
                boolean exists = false;
                for (int j = 0; j < sheetAttributes.size(); j++) {
                    Long sheetAttID = sheetAttributes.get(j).getAttributeID();
                    if (sheetAttID.equals(currentAttID)) {
                        exists = true;
                        break;
                    }
                }
                if (!exists) {
                    attributeRepository.deleteAttribute(currentAttID);
                }
            }

            for (int i = 0; i < sheetAttributes.size(); i++) {

                Long attID = sheetAttributes.get(i).getAttributeID();
                String newName = sheetAttributes.get(i).getAttributeName();
                String newDesc = sheetAttributes.get(i).getAttributeDesc();

                // Update Existing Attributes that have been edited
                if (attID != -1l) {
                    attributeRepository.updateAttribute(attID, newName, newDesc);
                } else { // Add Newly added ones
                    LMAttribute newAttribute = new LMAttribute();
                    newAttribute.setAttributeSheetID(sheetTargetID);
                    newAttribute.setAttributeName(newName);
                    newAttribute.setAttributeDesc(newDesc);
                    attributeService.saveNewAttribute(attributeRepository, newAttribute);
                }

            }

        } else { // Creating New Sheet

            // Get the new sheet's new ID
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

        }

        return "redirect:/sheets";
    }

    @RequestMapping(value = "/deleteSheet", method = RequestMethod.POST)
    public String deleteUserSheet(@RequestBody Long sheetID, HttpSession session) {

        LMSheetService service = new LMSheetService();
        service.deleteSheet(sheetRepository, attributeRepository, sheetID);

        // TODO Fix Refresh
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