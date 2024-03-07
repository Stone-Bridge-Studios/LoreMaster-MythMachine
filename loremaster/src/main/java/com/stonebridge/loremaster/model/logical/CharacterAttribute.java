package com.stonebridge.loremaster.model.logical;

public class CharacterAttribute {

    // Fields & Properties
    private Long cAttributeCharacterID;
    private Long cAttributeAttributeID;
    private String cAttributeValue;

    // Constructors
    public CharacterAttribute() { // Default
        cAttributeCharacterID = null;
        cAttributeAttributeID = null;
        cAttributeValue = "Empty Attribute";
    }

    // #region Accessors

    public Long getCAttributeCharacterID() {
        return cAttributeCharacterID;
    }

    public Long getCAttributeAttributeID() {
        return cAttributeAttributeID;
    }

    public String getCAttributeValue() {
        return cAttributeValue;
    }

    public void setCAttributeCharacterID(Long inputID) {
        cAttributeCharacterID = inputID;
    }

    public void setCAttributeAttributeID(Long inputID) {
        cAttributeAttributeID = inputID;
    }

    public void setCAttributeCharacterID(String value) {
        cAttributeValue = value;
    }

    // #endregion

    // #region Methods

    // #endregion

}
