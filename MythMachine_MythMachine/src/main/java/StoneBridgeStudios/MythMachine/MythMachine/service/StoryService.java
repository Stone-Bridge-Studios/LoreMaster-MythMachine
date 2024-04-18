package StoneBridgeStudios.MythMachine.MythMachine.service;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.mythmachine.model.Character;
//import com.mythmachine.repository.CharacterRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class StoryService {

	    @Autowired
	   // private CharacterRepository characterRepository;

	    public List<String> getGenres() {
	        // Genres most popular can be changed
	        return Arrays.asList("Drama", "Comedy", "Horror", "Fantasy", "Sci-Fi");
	    }
// need to add char repos connect db 
	    //public Iterable<Character> getCharacters() {
	    //    return characterRepository.findAll();

		public Iterable<Character> getCharacters() {
			// TODO Auto-generated method stub PLACEHOLDER CODE
			return null;
		}
	    }
	
