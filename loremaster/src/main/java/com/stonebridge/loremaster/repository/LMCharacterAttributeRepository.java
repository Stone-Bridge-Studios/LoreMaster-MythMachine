package com.stonebridge.loremaster.repository;

import com.stonebridge.loremaster.model.LMCharacterAttribute;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface LMCharacterAttributeRepository extends JpaRepository<LMCharacterAttribute, Long> {

    @Query(value = "SELECT * FROM lm_character_attributes WHERE character_id = :charID", nativeQuery = true)
    List<LMCharacterAttribute> getCharacterAttributes(Long charID);

    @Transactional
    @Modifying
    @Query(value = "UPDATE lm_character_attributes SET ca_value = :caValue WHERE character_id = :charID AND attribute_id = :attID", nativeQuery = true)
    void updateCharacterAttribute(Long charID, Long attID, String caValue);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM lm_character_attributes WHERE character_id = :charID", nativeQuery = true)
    void deleteAllCharacterAttributes(Long charID);

    // SQL Statement provided by Claude AI
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM lm_character_attributes bt WHERE NOT EXISTS ( SELECT * FROM lm_attribute WHERE lm_attribute.attribute_id = bt.attribute_id );", nativeQuery = true)
    void updateDeletedSheetAttributes();

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM lm_character_attributes bt WHERE NOT EXISTS ( SELECT * FROM lm_character WHERE lm_character.character_id = bt.character_id );", nativeQuery = true)
    void deleteOrphanedCharacterAttributes();

}