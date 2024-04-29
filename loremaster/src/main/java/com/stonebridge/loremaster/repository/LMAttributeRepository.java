package com.stonebridge.loremaster.repository;

import com.stonebridge.loremaster.model.LMAttribute;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface LMAttributeRepository extends JpaRepository<LMAttribute, Long> {

    @Query(value = "SELECT * FROM lm_attribute a WHERE a.attribute_id = :attributeID", nativeQuery = true)
    LMAttribute getAttribute(Long attributeID);

    @Query(value = "SELECT * FROM lm_attribute a WHERE a.sheet_id = :sheetID", nativeQuery = true)
    List<LMAttribute> getSheetAttributes(Long sheetID);

    @Transactional
    @Modifying
    @Query(value = "UPDATE lm_attribute SET attribute_name = :attributeName, attribute_desc = :attributeDesc WHERE attribute_id = :attributeID", nativeQuery = true)
    void updateAttribute(Long attributeID, String attributeName, String attributeDesc);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM lm_attribute WHERE attribute_id = :attributeID", nativeQuery = true)
    void deleteAttribute(Long attributeID);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM lm_attribute WHERE sheet_id = :sheetID", nativeQuery = true)
    void deleteAllSheetAttributes(Long sheetID);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM lm_attribute bt WHERE NOT EXISTS ( SELECT * FROM lm_sheet WHERE lm_sheet.sheet_id = bt.sheet_id );", nativeQuery = true)
    void deleteOrphanedAttributes();

}