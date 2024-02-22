package com.stonebridge.loremaster.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stonebridge.loremaster.model.LMUser;
import com.stonebridge.loremaster.repository.LMUserRepository;

@Service
public class LMUserService {

    public static boolean validateUser(String userid, String password) {
        return userid.equalsIgnoreCase("admin")
                && password.equalsIgnoreCase("password");
    }

    @Autowired
    private LMUserRepository userRepository;

    public List<LMUser> getAllUsers() {
        return userRepository.findAll();
    }

    @SuppressWarnings("null")
    public LMUser getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @SuppressWarnings("null")
    public LMUser createUser(LMUser user) {
        return userRepository.save(user);
    }

    @SuppressWarnings("null")
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @SuppressWarnings("null")
    public LMUser save(LMUser user) {
        return userRepository.save(user);
    }

    @SuppressWarnings("null")
    public Optional<LMUser> findById(Long id) {
        return userRepository.findById(id);
    }
}
