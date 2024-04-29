package com.stonebridge.loremaster.model.DTO;

public class AttributeDTO {
    private String attributeID = "-1"; // An ID of -1 indicates it is not an existing Attribute
    private String name;
    private String desc;

    public AttributeDTO(String inputID, String inputName, String inputDesc) {
        attributeID = inputID;
        name = inputName;
        desc = inputDesc;
    }

    public String getAttributeID() {
        return attributeID;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public void setAttribute(String inputID) {
        attributeID = inputID;
    }

    public void setName(String inputName) {
        name = inputName;
    }

    public void setDesc(String inputDesc) {
        desc = inputDesc;
    }

}
