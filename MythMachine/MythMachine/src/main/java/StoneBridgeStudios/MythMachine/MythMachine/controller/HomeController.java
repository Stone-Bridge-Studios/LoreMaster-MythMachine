package StoneBridgeStudios.MythMachine.MythMachine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import StoneBridgeStudios.MythMachine.MythMachine.service.UserService;

@Controller
@SessionAttributes("name")
public class HomeController {
@Autowired 
UserService service;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to Myth Machine!");
        return "index"; // This will return "index.jsp"
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model) {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password) {

        boolean isValidUser = service.validateUser(name, password);

        if (!isValidUser) {
            model.put("errorMessage", "Access Denied , Invalid Credentials");
            return "login";
        }

        model.put("name", name);
        model.put("password", password);

        return "welcome";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String showLogoutPage(ModelMap model) {
        return "login";
    }

}