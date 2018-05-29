package com.mahen.doorje.namaste.client.api.namaste;

public class NamasteAccount {

    private String accountId;
    private String email;
    private String password;

    public NamasteAccount(){}

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
