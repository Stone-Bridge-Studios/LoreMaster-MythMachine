package com.stonebridge.loremaster.repository;

import com.stonebridge.loremaster.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LMUserRepository extends JpaRepository<LMUser, Long> {
    // More Queries can go here
}