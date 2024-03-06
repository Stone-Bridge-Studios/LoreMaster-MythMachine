package com.stonebridge.loremaster.model;

import jakarta.persistence.*;

@Entity
@Table(name = "lm_character")
@SequenceGenerator(name = "character_sequence", sequenceName = "character_sequence", allocationSize = 1)
public class LMCharacter {

    // Getters, Setters & Column Names
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "character_sequence")
    @Column(name = "character_id")
    private Long characterID;

    public Long getCharacterID() {
        return characterID;
    }

    public void setCharacterID(Long inputID) {
        characterID = inputID;
    }

    @Column(name = "character_name")
    private String characterName;

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String inputCharacterName) {
        characterName = inputCharacterName;
    }

    @Column(name = "character_user_id")
    private String characterUserID;

    public String getCharacterUserID() {
        return characterUserID;
    }

    public void setCharacterUserID(String inputID) {
        characterUserID = inputID;
    }

    @Column(name = "character_sheet_id")
    private String characterSheetID;

    public String getCharacterSheetID() {
        return characterSheetID;
    }

    public void setCharacterSheetID(String inputID) {
        characterSheetID = inputID;
    }

}
