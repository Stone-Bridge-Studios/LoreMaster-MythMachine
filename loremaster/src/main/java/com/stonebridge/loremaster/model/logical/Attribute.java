package com.stonebridge.loremaster.model.logical;

public class Attribute {

    // Fields & Properties
    private Long attributeSheetID;
    private String attributeName;
    private String attributeDesc;

    // Constructors
    public Attribute() { // Default
        attributeSheetID = null;
        attributeName = "Empty Attribute";
        attributeDesc = "This attribute is empty!";
    }

    public Attribute(Long sheetID) {
        attributeSheetID = sheetID;
        attributeName = "Empty Attribute";
        attributeDesc = "This attribute is empty!";
    }

    public Attribute(Long sheetID, String name, String desc) {
        attributeSheetID = sheetID;
        attributeName = name;
        attributeDesc = desc;
    }

    // #region Accessors
    public Long getAttributeSheetID() {
        return attributeSheetID;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public String getAttributeDesc() {
        return attributeDesc;
    }

    public void setAttributeSheetID(Long inputID) {
        attributeSheetID = inputID;
    }

    public void setAttributeName(String inputName) {
        attributeName = inputName;
    }

    public void setAttributeDesc(String inputDesc) {
        attributeDesc = inputDesc;
    }
    // #endregion

    // #region Methods
    // #endregion

}
