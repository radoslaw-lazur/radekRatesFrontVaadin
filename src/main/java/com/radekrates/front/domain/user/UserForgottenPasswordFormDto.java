package com.radekrates.front.domain.user;

public class UserForgottenPasswordFormDto {
    private String userEmail;

    public UserForgottenPasswordFormDto(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
