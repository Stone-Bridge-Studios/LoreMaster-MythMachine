package com.stonebridge.loremaster.model.logical;

import java.util.List;

public class Character {

    // Fields & Properties
    private Long characterUserID;
    private Long characterSheetID;
    private String characterName;
    private List<CharacterAttribute> characterAttributes;

    // Constructors
    public Character() { // Default
        characterUserID = null;
        characterSheetID = null;
        characterName = "Unnamed Character";
        // TODO Create Blank Attributes based off of assigned Sheet's regular attributes
    }

    public Character(Long userID, Long sheetID) {
        characterUserID = userID;
        characterSheetID = sheetID;
        characterName = "Unnamed Character";
    }

    public Character(Long userID, Long sheetID, String name) {
        characterUserID = userID;
        characterSheetID = sheetID;
        characterName = name;
    }

    public Character(Long userID, Long sheetID, String name, List<CharacterAttribute> inputCAttributes) {
        characterUserID = userID;
        characterSheetID = sheetID;
        characterName = name;
        characterAttributes = inputCAttributes;
    }

    // #region Accessors
    public Long getCharacterUserID() {
        return characterUserID;
    }

    public Long getCharacterSheetID() {
        return characterSheetID;
    }

    public String getCharacterName() {
        return characterName;
    }

    public List<CharacterAttribute> getCharacterAttributes() {
        return characterAttributes;
    }

    public void setCharacterUserID(Long inputID) {
        characterUserID = inputID;
    }

    public void setCharacterSheetID(Long inputID) {
        characterSheetID = inputID;
    }

    public void setCharacterName(String inputName) {
        characterName = inputName;
    }
    // #endregion

}
