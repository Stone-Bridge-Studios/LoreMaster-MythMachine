package com.stonebridge.loremaster.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stonebridge.loremaster.model.LMAttribute;
import com.stonebridge.loremaster.repository.LMAttributeRepository;

@Service
public class LMAttributeService {

    @SuppressWarnings("null")
    public LMAttribute saveNewAttribute(LMAttributeRepository repository, LMAttribute attribute) {
        return repository.save(attribute);
    }

    public List<LMAttribute> getAttributesFromSheet(LMAttributeRepository repository, Long sheetID) {
        return repository.getSheetAttributes(sheetID);
    }

}
