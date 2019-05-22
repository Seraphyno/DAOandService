package com.sda.database.impl;

import com.google.common.collect.ImmutableMap;
import com.sda.database.api.IUser;

import java.util.Map;

public class DatabaseData {

    static final IUser ROOT = new User("root", "root@linux.com", "root");
    static final IUser GIGEL = new User("gigel", "gigel@yahoo.com", "123qweASD!");
    static final IUser DOREL = new User("dorel", "dorel@linux.com", "dorel99");
    static final IUser GUEST = new User("guest", "guest@windows.com", "guestUser");
    static final IUser THOR = new User("thor", "thor@asgard.as", "Mjolnir");


    static Map<String, IUser> buildDatabase() {
        return ImmutableMap.of(
                ROOT.getEmail(), ROOT,
                GUEST.getEmail(), GUEST,
                THOR.getEmail(), THOR,
                GIGEL.getEmail(), GIGEL,
                DOREL.getEmail(), DOREL
        );
    }
}
