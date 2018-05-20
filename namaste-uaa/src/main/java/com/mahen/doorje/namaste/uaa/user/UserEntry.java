package com.mahen.doorje.namaste.uaa.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserEntry {

    @Id
    @GeneratedValue
    private long id;

    private String username;
    private String password;

    @SuppressWarnings("unused")
    public UserEntry() {
    }

    public UserEntry(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
