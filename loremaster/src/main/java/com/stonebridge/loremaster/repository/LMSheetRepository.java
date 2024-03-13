package com.stonebridge.loremaster.repository;

import com.stonebridge.loremaster.model.LMSheet;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LMSheetRepository extends JpaRepository<LMSheet, Long> {

    @Query(value = "SELECT next_val FROM sheet_sequence", nativeQuery = true)
    Long getNextSheetID();

    @Query(value = "SELECT * FROM lm_sheet a WHERE a.user_id = :userID", nativeQuery = true)
    List<LMSheet> getUserSheets(Long userID);

}