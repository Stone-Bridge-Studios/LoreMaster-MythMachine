package StoneBridgeStudios.MythMachine.MythMachine.service;

import org.springframework.stereotype.Service;
import StoneBridgeStudios.MythMachine.MythMachine.model.MMUser;
import StoneBridgeStudios.MythMachine.MythMachine.repository.MMUserRepository;

@Service
public class UserService {

    public boolean validateUser(MMUserRepository repository,String userEmail, String userPassword) {
    	MMUser user = repository.findByEmail(userEmail);

        if (user == null)
            return false;

        if (user.getPassword().equals(userPassword))
            return true;
        return false;
    }
    public boolean accountExists(MMUserRepository repository, String userEmail, String userName) {

        MMUser user = repository.findByEmail(userEmail);

        if (user == null)
            return false;

        if (user.getEmail().equals(userEmail) || user.getUsername().equals(userName))
            return true;
        return false;

    }

    @SuppressWarnings("null")
    public MMUser saveNewUser(MMUserRepository repository, MMUser user) {
        return repository.save(user);
    }

}