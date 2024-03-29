package com.stonebridge.loremaster.repository;

import com.stonebridge.loremaster.model.LMCharacter;

import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public interface LMCharacterRepository extends JpaRepository<LMCharacter, Long> {

    @Query(value = "SELECT * FROM lm_character c WHERE c.user_id = :userID", nativeQuery = true)
    List<LMCharacter> findByUserID(String userID);

    @Query(value = "SELECT next_val FROM character_sequence", nativeQuery = true)
    Long getNextCharacterID();

    @Query(value = "SELECT * FROM lm_character a WHERE a.user_id = :userID", nativeQuery = true)
    List<LMCharacter> getUserCharacters(Long userID);

    @Query(value = "SELECT sheet_id FROM lm_character WHERE character_id = :charID", nativeQuery = true)
    Long getCharacterSheetID(Long charID);

    @Query(value = "SELECT character_name FROM lm_character WHERE character_id = :charID", nativeQuery = true)
    String getCharacterName(Long charID);

    @Transactional
    @Modifying
    @Query(value = "UPDATE lm_character SET character_name = :charName WHERE character_id = :charID", nativeQuery = true)
    void updateCharacterName(Long charID, String charName);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM lm_character WHERE character_id = :charID", nativeQuery = true)
    void deleteCharacter(Long charID);

}