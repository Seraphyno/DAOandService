package com.sda.database.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.sda.database.api.IUser;

class DatabaseData {

    private static final IUser ROOT = new User("root", "root@linux.com", "root");
    private static final IUser GIGEL = new User("gigel", "gigel@yahoo.com", "123qweASD!");
    private static final IUser DOREL = new User("dorel", "dorel@linux.com", "dorel99");
    private static final IUser GUEST = new User("guest", "guest@windows.com", "guestUser");
    private static final IUser THOR = new User("thor", "thor@asgard.as", "Mjolnir");

    private DatabaseData() {
        throw new IllegalAccessError("Utility class");
    }

    static Map<String, IUser> buildDatabase() {
        Map<String, IUser> result = new HashMap<>();
        result.put(ROOT.getId(), ROOT);
        result.put(GUEST.getId(), GUEST);
        result.put(THOR.getId(), THOR);
        result.put(GIGEL.getId(), GIGEL);
        result.put(DOREL.getId(), DOREL);

        return result;
    }

    static List<IUser> getUserList() {
        List<IUser> result = new LinkedList<>();
        result.addAll(buildDatabase().values());

        return result;
    }
}
