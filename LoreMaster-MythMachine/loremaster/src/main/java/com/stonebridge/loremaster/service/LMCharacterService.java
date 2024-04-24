package com.stonebridge.loremaster.service;

//import java.util.List;

import org.springframework.stereotype.Service;

import com.stonebridge.loremaster.model.LMCharacter;
import com.stonebridge.loremaster.repository.LMCharacterAttributeRepository;
import com.stonebridge.loremaster.repository.LMCharacterRepository;

@Service
public class LMCharacterService {

    @SuppressWarnings("null")
    public LMCharacter saveNewCharacter(LMCharacterRepository repository,
            LMCharacter newCharacter) {
        return repository.save(newCharacter);
    }

    public void deleteCharacter(LMCharacterRepository characterRepository,
            LMCharacterAttributeRepository charAttributeRepository, Long charID) {
        charAttributeRepository.deleteAllCharacterAttributes(charID);
        characterRepository.deleteCharacter(charID);
    }

    public void deleteCharacterBySheet(LMCharacterRepository characterRepository,
            LMCharacterAttributeRepository charAttributeRepository, Long sheetID) {
        characterRepository.deleteCharactersBySheet(sheetID);
        charAttributeRepository.deleteOrphanedCharacterAttributes();
    }

}
