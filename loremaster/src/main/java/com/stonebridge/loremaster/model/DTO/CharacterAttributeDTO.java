package com.stonebridge.loremaster.model.DTO;

public class CharacterAttributeDTO {
    // TODO Fix getter and setter mapping (so these can be private)
    public String characterID;
    public String attributeID;
    public String ca_value;
    public String characterName;

    public CharacterAttributeDTO(String inputCharID, String inputAttID, String inputValue, String inputCharacterName) {
        characterID = inputCharID;
        attributeID = inputAttID;
        ca_value = inputValue;
        characterName = inputCharacterName;
    }

    // Getters
    public String getCharacterID() {
        return characterID;
    }

    public String getAttributeID() {
        return attributeID;
    }

    public String getCa_Value() {
        return this.ca_value;
    }

    // Setters
    public void setCharacterID(String inputCharID) {
        characterID = inputCharID;
    }

    public void setAttributeID(String inputAttID) {
        attributeID = inputAttID;
    }

    public void setCa_Value(String inputValue) {
        ca_value = inputValue;
    }
}
