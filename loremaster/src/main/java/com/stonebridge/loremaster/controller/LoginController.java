package com.stonebridge.loremaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.stonebridge.loremaster.model.LMUser;
import com.stonebridge.loremaster.repository.LMUserRepository;
import com.stonebridge.loremaster.service.LMUserService;

import org.mindrot.jbcrypt.*;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private LMUserRepository userRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to LoreMaster!");
        return "redirect:/login"; // This will return "index.jsp"
    }

    // Display Login Page
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model) {
        return "login";
    }

    // Get Information From Login
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model, HttpSession session, @RequestParam String email,
            @RequestParam String password) {

        LMUserService service = new LMUserService();
        LMUser user = userRepository.findByEmail(email);

        boolean isValidUser = false;

        // Re-hash the input password
        if (user != null) {
            String hashed = BCrypt.hashpw(password, user.getSalt());
            isValidUser = (BCrypt.checkpw(password, hashed)) ? service.validateUser(userRepository, email, hashed)
                    : false;
        }

        if (!isValidUser) {
            model.put("errorMessage", "Your account email or password is incorrect. Please try again.");
            return "login";
        }

        model.put("email", email);
        model.put("password", password);

        // Store User ID & Username in Session

        String username = userRepository.getUserName(user.getUserID());
        session.setAttribute("userID", user.getUserID());
        session.setAttribute("userName", username);

        return "stories";
    }

    // Display Logout Page (Just return to the login page for now)
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String showLogoutPage(ModelMap model) {
        return "login";
    }

    // Display Account Creation Page
    @RequestMapping(value = "/createAccount", method = RequestMethod.GET)
    public String showCreateAccountPage(ModelMap model) {
        return "createAccount";
    }

    @RequestMapping(value = "/createAccount", method = RequestMethod.POST)
    public String showAccountCreatedPage(ModelMap model, @RequestParam String email, @RequestParam String name,
            @RequestParam String password) {

        // Check if the account being created already exists
        LMUserService service = new LMUserService();
        boolean userExists = service.accountExists(userRepository, email, name);

        // If so, reject the creation and display an error message
        if (userExists) {
            model.put("errorMessage", "Account Creation Failed: Email or Username Already in Use");
            return "createAccount";
        }
        // Otherwise, add the new user to the database and automatically log the user in
        else {

            // Generate a Salt for the user
            String salt = BCrypt.gensalt();

            // Hash the input password with the salt
            String hashed = BCrypt.hashpw(password, salt);

            LMUser newUser = new LMUser();
            newUser.setEmail(email);
            newUser.setUsername(name);
            newUser.setPassword(hashed);
            newUser.setSalt(salt);
            newUser.setIsAdmin(false);
            service.saveNewUser(userRepository, newUser);
            return "redirect:/login";
        }
    }
}