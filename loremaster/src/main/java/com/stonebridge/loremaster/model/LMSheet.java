package com.stonebridge.loremaster.model;

import jakarta.persistence.*;

@Entity
@Table(name = "lm_sheet")
@SequenceGenerator(name = "sheet_sequence", sequenceName = "sheet_sequence", allocationSize = 1)
public class LMSheet {

    // Getters, Setters & Column Names
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sheet_sequence")
    @Column(name = "sheet_id")
    private Long sheetID;

    public Long getSheetID() {
        return sheetID;
    }

    public void setSheetID(Long inputID) {
        sheetID = inputID;
    }

    @Column(name = "sheet_name")
    private String sheetName;

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String inputSheetName) {
        sheetName = inputSheetName;
    }

    @Column(name = "user_id")
    private Long sheetUserID;

    public Long getSheetUserID() {
        return sheetUserID;
    }

    public void setSheetUserID(Long inputID) {
        sheetUserID = inputID;
    }

}