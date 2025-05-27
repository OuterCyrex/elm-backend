package com.elm.model.entity;

public class User {
    private String userId;
    private String password;
    private String userName;
    private short userSex;
    private String userImg;
    private short delTag;

    public User(String userId, String password, String userName, String userImg, short userSex, short delTag) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.userImg = userImg;
        this.userSex = userSex;
        this.delTag = delTag;
    }

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


