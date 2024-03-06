package com.stonebridge.loremaster.repository;

import com.stonebridge.loremaster.model.LMUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LMUserRepository extends JpaRepository<LMUser, Long> {

    @Query(value = "SELECT * FROM sb_user u WHERE u.user_email = :email", nativeQuery = true)
    LMUser findByEmail(String email);

}