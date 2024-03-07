package com.stonebridge.loremaster.service;

//import java.util.List;

import org.springframework.stereotype.Service;

import com.stonebridge.loremaster.model.LMCharacterAttribute;
import com.stonebridge.loremaster.repository.LMCharacterAttributeRepository;

@Service
public class LMCharacterAttributeService {

    @SuppressWarnings("null")
    public LMCharacterAttribute saveNewCharacterAttribute(LMCharacterAttributeRepository characterRepository,
            LMCharacterAttribute attribute) {
        return characterRepository.save(attribute);
    }

}
