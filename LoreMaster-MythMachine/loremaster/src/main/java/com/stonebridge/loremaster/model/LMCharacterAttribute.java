package com.stonebridge.loremaster.model;

import jakarta.persistence.*;

@Entity
@Table(name = "lm_character_attributes")
@SequenceGenerator(name = "character_attributes_sequence", sequenceName = "character_attributes_sequence", allocationSize = 1)
public class LMCharacterAttribute {

    // Getters, Setters & Column Names
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "character_attributes_sequence")
    @Column(name = "ca_id")
    private Long caID;

    public Long getCaID() {
        return caID;
    }

    @Column(name = "character_id")
    private Long characterID;

    public Long getCharacterID() {
        return characterID;
    }

    public void setCharacterID(Long inputID) {
        characterID = inputID;
    }

    @Column(name = "attribute_id")
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

    public void setCAValue(String inputValue) {
        CAValue = inputValue;
    }

}
