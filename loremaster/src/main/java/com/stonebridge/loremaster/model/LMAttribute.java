package com.stonebridge.loremaster.model;

import jakarta.persistence.*;

@Entity
@Table(name = "lm_attribute")
@SequenceGenerator(name = "attribute_sequence", sequenceName = "attribute_sequence", allocationSize = 1)
public class LMAttribute {

    // Getters, Setters & Column Names
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attribute_sequence")
    @Column(name = "attribute_id")
    private Long attributeID;

    public Long getAttributeID() {
        return attributeID;
    }

    public void setAttributeID(Long inputID) {
        attributeID = inputID;
    }

    @Column(name = "attribute_name")
    private String attributeName;

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String inputAttributeName) {
        attributeName = inputAttributeName;
    }

    @Column(name = "attribute_desc")
    private String attributeDesc;

    public String getAttributeDesc() {
        return attributeDesc;
    }

    public void setAttributeDesc(String inputAttributeDesc) {
        attributeDesc = inputAttributeDesc;
    }

    @Column(name = "sheet_id")
    private Long attributeSheetID;

    public Long getAttributeSheetID() {
        return attributeSheetID;
    }

    public void setAttributeSheetID(Long inputID) {
        attributeSheetID = inputID;
    }

}
