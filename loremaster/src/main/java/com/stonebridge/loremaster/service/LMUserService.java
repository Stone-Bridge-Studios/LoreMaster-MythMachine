package com.stonebridge.loremaster.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.stonebridge.loremaster.model.LMUser;
import com.stonebridge.loremaster.repository.LMUserRepository;

@Service
public class LMUserService {

    public boolean validateUser(LMUserRepository repository, String userEmail, String userPassword) {

        // TODO Find a faster way to do this

        List<LMUser> users = repository.findAll();
        for (LMUser user : users)
            if (user.getEmail().equals(userEmail) && user.getPassword().equals(userPassword)) {
                return true;
            }
        return false;

    }

    public boolean accountExists(LMUserRepository repository, String userEmail, String userName) {

        // TODO Find a faster way to do this

        List<LMUser> users = repository.findAll();

        for (LMUser user : users)
            if (user.getEmail().equals(userEmail) || user.getUsername().equals(userName))
                return true;

        return false;

    }

    @SuppressWarnings("null")
    public LMUser saveNewUser(LMUserRepository repository, LMUser user) {
        return repository.save(user);
    }

}
