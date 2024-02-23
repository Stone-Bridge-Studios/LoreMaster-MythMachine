package com.stonebridge.loremaster.model;

import jakarta.persistence.*;

@Entity
@Table(name = "lm_user")
@SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
public class LMUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @Column(name = "user_id")
    private Long userID;

    private String username;
    private String userPassword;
    private String userEmail;

    // Getters and setters
    public Long getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return userPassword;
    }

    public String getEmail() {
        return userEmail;
    }

    public void setUserID(Long inputID) {
        userID = inputID;
    }

    public void setUsername(String inputUserName) {
        username = inputUserName;
    }

    public void setPassword(String inputPassword) {
        userPassword = inputPassword;
    }

    public void setEmail(String inputEmail) {
        userEmail = inputEmail;
    }
}