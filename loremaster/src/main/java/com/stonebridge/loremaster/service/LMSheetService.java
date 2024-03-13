package com.stonebridge.loremaster.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stonebridge.loremaster.model.LMSheet;
import com.stonebridge.loremaster.repository.LMSheetRepository;

@Service
public class LMSheetService {

    @SuppressWarnings("null")
    public LMSheet saveNewSheet(LMSheetRepository repository, LMSheet sheet) {
        return repository.save(sheet);
    }

    public Long GetNextSheetID(LMSheetRepository repository) {
        return repository.getNextSheetID();
    }

    public List<LMSheet> getUserSheets(LMSheetRepository repository, Long userID) {
        return repository.getUserSheets(userID);
    }

}
