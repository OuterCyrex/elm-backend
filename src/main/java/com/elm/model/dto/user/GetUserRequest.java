package com.elm.model.dto.user;

public class GetUserRequest {
    private String userId;

    public  GetUserRequest(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
