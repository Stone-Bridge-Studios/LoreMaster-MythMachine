package com.stonebridge.loremaster.repository;

import com.stonebridge.loremaster.model.LMCharacter;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LMCharacterRepository extends JpaRepository<LMCharacter, Long> {

    @Query(value = "SELECT * FROM lm_character c WHERE c.user_id = :userID", nativeQuery = true)
    List<LMCharacter> findByUserID(String userID);

}