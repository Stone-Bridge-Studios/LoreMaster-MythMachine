package StoneBridgeStudios.MythMachine.MythMachine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import StoneBridgeStudios.MythMachine.MythMachine.service.StoryService;

@Controller
public class StoryController {
	//Story service here
	    @Autowired
	    private StoryService storyService;

	    @GetMapping("/")
	    public String home() {
	        return "login";
	    }

	    @GetMapping("/chooseStory")
	    public String chooseStory(Model model) {
	        // Add genres to the model to populate the drop down in html file
	        model.addAttribute("genres", storyService.getGenres());
	        return "chooseStory";
	    }

	    @GetMapping("/newStory")
	    public String newStory(
	            @RequestParam(name = "genre", required = false) String genre,
	            @RequestParam(name = "useCharacter", required = false) String useCharacter,
	            Model model) {

	        if ("existing".equals(useCharacter)) {
	            // Fetch characters from the database
	            Iterable<Character> characters = storyService.getCharacters();
	            model.addAttribute("characters", characters);
	        }
	        // Add the selected genre to the model
	        model.addAttribute("selectedGenre", genre);

	        return "newStory";
	    }
	}

	//