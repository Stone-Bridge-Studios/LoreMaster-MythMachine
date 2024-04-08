package com.stonebridge.loremaster.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stonebridge.loremaster.model.LMCharacter;
import com.stonebridge.loremaster.model.LMSheet;
import com.stonebridge.loremaster.repository.LMCharacterRepository;
import com.stonebridge.loremaster.repository.LMSheetRepository;
import com.stonebridge.loremaster.repository.LMUserRepository;

import jakarta.servlet.http.HttpSession;

// Manage Home Pages
@Controller
public class HomeController {

    @Autowired
    private LMSheetRepository sheetRepository;

    @Autowired
    private LMCharacterRepository characterRepository;

    @Autowired
    private LMUserRepository userRepository;

    @RequestMapping(value = "/characters", method = RequestMethod.GET)
    public String showCharactersPage(HttpSession session, ModelMap model) {

        // Get All of the Logged in User's Characters
        List<LMCharacter> userCharacters = characterRepository.getUserCharacters((Long) session.getAttribute("userID"));
        model.addAttribute("userCharacters", userCharacters);

        return "characters";
    }

    @RequestMapping(value = "/sheets", method = RequestMethod.GET)
    public String showSheetsPage(HttpSession session, ModelMap model) {

        // Get All of the Logged in User's Character Sheets
        List<LMSheet> userSheets = sheetRepository.getUserSheets((Long) session.getAttribute("userID"));
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

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String showProfilePage(HttpSession session, ModelMap model) {
        return "profile";
    }

    // Profile Editing
    @RequestMapping(value = "/logoutUser", method = RequestMethod.GET)
    public String logoutUser(HttpSession session) {
        session.removeAttribute("userID");
        session.removeAttribute("userName");
        return "redirect:/login";
    }

    @RequestMapping(value = "/deleteAccount", method = RequestMethod.GET)
    public String deleteAccount(HttpSession session) {
        Long userID = (Long) session.getAttribute("userID");
        userRepository.deleteUser(userID);
        return "redirect:/login";
    }

}