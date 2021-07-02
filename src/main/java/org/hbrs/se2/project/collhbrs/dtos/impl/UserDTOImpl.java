package org.hbrs.se2.project.collhbrs.dtos.impl;

import org.hbrs.se2.project.collhbrs.dtos.UserDTO;

import java.util.Arrays;

public class UserDTOImpl implements UserDTO {


    private int userId;
    private String firstName;
    private String lastName;
    private String eMail;
    private String password;
    private String username;
    private String userTyp;

    private byte[] profilePicture;

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public UserDTOImpl() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserTyp() {
        return userTyp;
    }

    public void setUserTyp(String userTyp) {
        this.userTyp = userTyp;
    }

    @Override
    public String toString() {
        return "UserDTOImpl{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", userTyp='" + userTyp + '\'' +
                ", profilePicture=" + Arrays.toString(profilePicture) +
                '}';
    }
}
