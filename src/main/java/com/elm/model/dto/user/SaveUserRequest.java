package com.elm.model.dto.user;

public class SaveUserRequest {
    private String userId;
    private String password;
    private String userName;
    private short userSex;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public short getUserSex() {
        return userSex;
    }

    public void setUserSex(short userSex) {
        this.userSex = userSex;
    }

    public SaveUserRequest() {
    }

    public SaveUserRequest(String userId, String password, String userName, short userSex) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.userSex = userSex;
    }
}
