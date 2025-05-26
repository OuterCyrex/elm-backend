package com.elm.model;

public class User {
    private String userId;
    private String password;
    private String userName;
    private short userSex;
    private String userImg;
    private short delTag;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public short getUserSex() {
        return userSex;
    }

    public void setUserSex(short userSex) {
        this.userSex = userSex;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public short getDelTag() {
        return delTag;
    }

    public void setDelTag(short delTag) {
        this.delTag = delTag;
    }
}


