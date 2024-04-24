package com.stonebridge.loremaster.repository;

import com.stonebridge.loremaster.model.LMUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public interface LMUserRepository extends JpaRepository<LMUser, Long> {

    @Query(value = "SELECT * FROM sb_user u WHERE u.user_email = :email", nativeQuery = true)
    LMUser findByEmail(String email);

    @Query(value = "SELECT username FROM sb_user u WHERE u.user_id = :userID", nativeQuery = true)
    String getUserName(Long userID);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM sb_user WHERE user_id = :userID", nativeQuery = true)
    void deleteUser(Long userID);

}