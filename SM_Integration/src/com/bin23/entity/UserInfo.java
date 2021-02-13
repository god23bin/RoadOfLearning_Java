package com.bin23.entity;

public class UserInfo {
    private Integer userId;
    private String phoneNumber;
    private String username;
    private String password;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public UserInfo() {

    }

    public UserInfo(Integer userId, String phoneNumber, String username, String password) {
        this.userId = userId;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
    }
}
