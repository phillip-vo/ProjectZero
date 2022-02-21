package com.revature.model;

public class RunnerLogin {
    private int loginId;
    private String username;
    private String password;

    public RunnerLogin(int loginId, String username, String password) {
        this.loginId = loginId;
        this.username = username;
        this.password = password;
    }

    public RunnerLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
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

    @Override
    public String toString() {
        return "Runner_Login{" + "loginId='" + loginId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' + "}";
    }
}
