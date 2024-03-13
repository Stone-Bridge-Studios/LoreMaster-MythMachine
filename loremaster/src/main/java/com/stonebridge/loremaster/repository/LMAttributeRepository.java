package com.stonebridge.loremaster.repository;

import com.stonebridge.loremaster.model.LMAttribute;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LMAttributeRepository extends JpaRepository<LMAttribute, Long> {

    @Query(value = "SELECT * FROM lm_attribute a WHERE a.sheet_id = :sheetID", nativeQuery = true)
    List<LMAttribute> getSheetAttributes(Long sheetID);

}