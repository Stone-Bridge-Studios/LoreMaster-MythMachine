package com.stonebridge.loremaster.model;

import jakarta.persistence.*;

@Entity
@Table(name = "lm_character_attributes")
@SequenceGenerator(name = "character_attributes_sequence", sequenceName = "character_attributes_sequence", allocationSize = 1)
public class LMCharacterAttributes {

    // Getters, Setters & Column Names
    @Id
    @Column(name = "ca_character_id")
    private Long characterID;

    public Long getCharacterID() {
        return characterID;
    }

    public void setCharacterID(Long inputID) {
        characterID = inputID;
    }

    @Id
    @Column(name = "ca_attribute_id")
    private Long attributeID;

    public Long getAttributeID() {
        return attributeID;
    }

    public void setAttributeID(Long inputID) {
        attributeID = inputID;
    }

    @Column(name = "ca_value")
    private String CAValue;

    public String getCAValue() {
        return CAValue;
    }

    public void setCharacterUserID(String inputValue) {
        CAValue = inputValue;
    }

}
