package com.project.FlightJDBC.entity;

/**
 * @author Pham Minh Luan
 * @email phamminhluan@fabercompany.co.jp
 */
public class User {
    private long userId;
    private String userAccount;
    private String userPassword;
    private int active;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
