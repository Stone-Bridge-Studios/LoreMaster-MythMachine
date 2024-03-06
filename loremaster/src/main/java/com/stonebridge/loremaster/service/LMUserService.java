package com.stonebridge.loremaster.service;

import org.springframework.stereotype.Service;

import com.stonebridge.loremaster.model.LMUser;
import com.stonebridge.loremaster.repository.LMUserRepository;

@Service
public class LMUserService {

    public boolean validateUser(LMUserRepository repository, String userEmail, String userPassword) {

        LMUser user = repository.findByEmail(userEmail);

        if (user == null)
            return false;

        if (user.getPassword().equals(userPassword))
            return true;
        return false;

    }

    public boolean accountExists(LMUserRepository repository, String userEmail, String userName) {

        LMUser user = repository.findByEmail(userEmail);

        if (user == null)
            return false;

        if (user.getEmail().equals(userEmail) || user.getUsername().equals(userName))
            return true;
        return false;

    }

    @SuppressWarnings("null")
    public LMUser saveNewUser(LMUserRepository repository, LMUser user) {
        return repository.save(user);
    }

}
