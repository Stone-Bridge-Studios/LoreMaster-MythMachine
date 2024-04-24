package com.stonebridge.loremaster.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stonebridge.loremaster.model.LMCharacter;
import com.stonebridge.loremaster.model.LMSheet;
import com.stonebridge.loremaster.repository.LMAttributeRepository;
import com.stonebridge.loremaster.repository.LMCharacterAttributeRepository;
import com.stonebridge.loremaster.repository.LMCharacterRepository;
import com.stonebridge.loremaster.repository.LMSheetRepository;
import com.stonebridge.loremaster.repository.LMUserRepository;
import com.stonebridge.loremaster.service.LMUserService;

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

    @Autowired
    private LMAttributeRepository attributeRepository;

    @Autowired
    private LMCharacterAttributeRepository characterAttributeRepository;



    @RequestMapping(value = "/stories", method = RequestMethod.GET)
    public String showExplorePage(ModelMap model) {
        return "stories";
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

    @RequestMapping(value = "/anthropic", method = RequestMethod.GET)
    public String anthropic(HttpSession session) {
        return "/anthropic";
    }

    @RequestMapping(value = "/storyEditor", method = RequestMethod.GET)
    public String storyEditor(HttpSession session) {
        return "/storyEditor";
    }

}