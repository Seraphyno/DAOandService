package com.sda.database.impl;

import com.sda.database.api.IUser;

import java.time.LocalDateTime;

public class User implements IUser {

    private String id;
    private String name;
    private String email;
    private char[] password;
    private LocalDateTime timeCreated;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.timeCreated = LocalDateTime.now();
        this.password = password.toCharArray();
        this.id = email;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public char[] getPassword() {
        return password;
    }

    @Override
    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }
}
