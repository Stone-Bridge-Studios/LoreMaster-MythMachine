package com.stonebridge.loremaster.service;

//import java.util.List;

import org.springframework.stereotype.Service;

import com.stonebridge.loremaster.model.LMCharacterAttribute;
import com.stonebridge.loremaster.repository.LMCharacterAttributeRepository;
import com.stonebridge.loremaster.repository.LMCharacterRepository;

@Service
public class LMCharacterAttributeService {

    @SuppressWarnings("null")
    public LMCharacterAttribute saveNewCharacterAttribute(LMCharacterAttributeRepository characterRepository,
            LMCharacterAttribute attribute) {
        return characterRepository.save(attribute);
    }

    public void updateCharactersSheetAdded(LMCharacterRepository characterRepository,
            LMCharacterAttributeRepository charAttributeRepository, Long sheetID) {
        // Called when new Sheet attributes are added

        // Get all Characters that use the sheet

    }

    public void updateCharactersSheetRemoved(LMCharacterAttributeRepository charAttributeRepository) {
        // Called when Sheet attributes are removed
        charAttributeRepository.updateDeletedSheetAttributes();

    }

    public void updateCharactersSheetDeleted(LMCharacterRepository characterRepository,
            LMCharacterAttributeRepository charAttributeRepository, Long sheetID) {
        // Called when entire Sheets are deleted

    }

}
