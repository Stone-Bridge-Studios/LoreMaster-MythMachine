package StoneBridgeStudios.MythMachine.MythMachine.model;

import jakarta.persistence.*;

@Entity
@Table(name = "mm_user")
@SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
public class MMUser {

    // Getters, Setters & Column Names
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @Column(name = "user_id")
    private Long userID;

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long inputID) {
        userID = inputID;
    }

    @Column(name = "username")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String inputUserName) {
        username = inputUserName;
    }

    @Column(name = "password")
    private String userPassword;

    public String getPassword() {
        return userPassword;
    }

    public void setPassword(String inputPassword) {
        userPassword = inputPassword;
    }

    @Column(name = "user_email")
    private String userEmail;

    public String getEmail() {
        return userEmail;
    }

    public void setEmail(String inputEmail) {
        userEmail = inputEmail;
    }

    @Column(name = "is_admin")
    private boolean isAdmin;

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean inputIsAdmin) {
        isAdmin = inputIsAdmin;
    }

}