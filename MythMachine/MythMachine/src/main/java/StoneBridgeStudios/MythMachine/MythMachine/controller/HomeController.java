package StoneBridgeStudios.MythMachine.MythMachine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import StoneBridgeStudios.MythMachine.MythMachine.service.UserService;
import StoneBridgeStudios.MythMachine.MythMachine.model.MMUser;
import StoneBridgeStudios.MythMachine.MythMachine.repository.MMUserRepository;

@Controller
public class HomeController {
	
@Autowired 
private MMUserRepository userRepository;

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
    public String showWelcomePage(ModelMap model, @RequestParam String email, @RequestParam String password) {

        UserService service = new UserService();
        boolean isValidUser = service.validateUser(userRepository, email, password);

        if (!isValidUser) {
            model.put("errorMessage", "Your account email or password is incorrect. Please try again.");
            return "login";
        }

        model.put("email", email);
        model.put("password", password);

        return "welcome";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String showLogoutPage(ModelMap model) {
        return "login";
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showCreateAccountPage(ModelMap model) {
        return "createAccount";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String showAccountCreatedPage(ModelMap model, @RequestParam String email, @RequestParam String name,
            @RequestParam String password) {

        // Check if the account being created already exists
        UserService service = new UserService();
        boolean userExists = service.accountExists(userRepository, email, name);

        // If so, reject the creation and display an error message
        if (userExists) {
            model.put("errorMessage", "Account Creation Failed: Email or Username Already in Use");
            return "createAccount";
        }
        // Otherwise, add the new user to the database and automatically log the user in
        else {
            MMUser newUser = new MMUser();
            newUser.setEmail(email);
            newUser.setUsername(name);
            newUser.setPassword(password);
            newUser.setIsAdmin(false);
            service.saveNewUser(userRepository, newUser);
            return "welcome";
        }
    }

}