package com.stonebridge.loremaster.service;

//import java.util.List;

import org.springframework.stereotype.Service;

import com.stonebridge.loremaster.model.LMCharacter;
import com.stonebridge.loremaster.repository.LMCharacterRepository;

@Service
public class LMCharacterService {

    @SuppressWarnings("null")
    public LMCharacter saveNewCharacter(LMCharacterRepository repository,
            LMCharacter newCharacter) {
        return repository.save(newCharacter);
    }

}
