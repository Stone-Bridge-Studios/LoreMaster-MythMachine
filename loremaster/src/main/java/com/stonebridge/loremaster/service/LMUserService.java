package com.stonebridge.loremaster.service;

import org.springframework.stereotype.Service;

import com.stonebridge.loremaster.model.LMUser;
import com.stonebridge.loremaster.repository.LMAttributeRepository;
import com.stonebridge.loremaster.repository.LMCharacterAttributeRepository;
import com.stonebridge.loremaster.repository.LMCharacterRepository;
import com.stonebridge.loremaster.repository.LMSheetRepository;
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

    @SuppressWarnings("null")
    public void deleteAllUserContent(Long userID, LMSheetRepository sheetRepository,
            LMCharacterRepository characterRepository, LMAttributeRepository attributeRepository,
            LMCharacterAttributeRepository charAttributeRepository) {

        // Delete All User Sheets
        sheetRepository.deleteSheetByUser(userID);

        // Delete All Characters
        characterRepository.deleteCharactersByUser(userID);

        // Delete Orphaned Attributes
        attributeRepository.deleteOrphanedAttributes();

        // Delete Orphaned Character Attributes
        charAttributeRepository.deleteOrphanedCharacterAttributes();

    }

}
