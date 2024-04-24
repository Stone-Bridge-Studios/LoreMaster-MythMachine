package com.stonebridge.loremaster.repository;

import com.stonebridge.loremaster.model.LMSheet;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public interface LMSheetRepository extends JpaRepository<LMSheet, Long> {

    @Query(value = "SELECT next_val FROM sheet_sequence", nativeQuery = true)
    Long getNextSheetID();

    @Query(value = "SELECT * FROM lm_sheet a WHERE a.user_id = :userID", nativeQuery = true)
    List<LMSheet> getUserSheets(Long userID);

    @Query(value = "SELECT sheet_name FROM lm_sheet a WHERE a.sheet_id = :sheetID", nativeQuery = true)
    String getSheetName(Long sheetID);

    @Transactional
    @Modifying
    @Query(value = "UPDATE lm_sheet SET sheet_name = :sheetName WHERE sheet_id = :sheetID", nativeQuery = true)
    void updateSheetName(Long sheetID, String sheetName);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM lm_sheet WHERE sheet_id = :sheetID", nativeQuery = true)
    void deleteSheet(Long sheetID);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM lm_sheet WHERE user_id = :userID", nativeQuery = true)
    void deleteSheetByUser(Long userID);

}