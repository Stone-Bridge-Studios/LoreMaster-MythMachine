package com.stonebridge.loremaster.model.logical;

import java.util.List;

public class Sheet {

    // Fields & Properties
    private Long sheetUserID;
    private String sheetName;
    private List<Attribute> sheetAttributes;

    // Constructors
    public Sheet() { // Default
        sheetUserID = null;
        sheetName = "Unnamed Sheet";
    }

    public Sheet(Long userID) {
        sheetUserID = userID;
        sheetName = "Unnamed Sheet";
    }

    public Sheet(Long userID, String name) {
        sheetUserID = userID;
        sheetName = name;
    }

    // #region Accessors
    public Long getSheetSheetID() {
        return sheetUserID;
    }

    public String getSheetName() {
        return sheetName;
    }

    public List<Attribute> getSheetAttributes() {
        return sheetAttributes;
    }

    public void setSheetSheetID(Long inputID) {
        sheetUserID = inputID;
    }

    public void setSheetName(String inputName) {
        sheetName = inputName;
    }
    // #endregion

}
