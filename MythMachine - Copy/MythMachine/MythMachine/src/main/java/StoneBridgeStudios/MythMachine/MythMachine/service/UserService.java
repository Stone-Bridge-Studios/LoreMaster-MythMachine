package StoneBridgeStudios.MythMachine.MythMachine.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public boolean validateUser(String userid, String password) {
        return userid.equalsIgnoreCase("admin")
                && password.equalsIgnoreCase("password");
    }

}