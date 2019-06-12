package com.sda.database.impl;

import static com.sda.database.impl.DatabaseData.buildDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sda.database.api.IDatabaseAccess;
import com.sda.database.api.IUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Database implements IDatabaseAccess {

    private static final Logger LOGGER = LoggerFactory.getLogger(Database.class);
    private Map<String, IUser> data = buildDatabase();

    @Override
    public IUser getById(String id) {
        LOGGER.debug("Getting user with id '{}'", id);
        IUser user = null;
        if (data.containsKey(id)) {
            LOGGER.info("Found user with id '{}'", id);
            user = data.get(id);
        } else {
            LOGGER.warn("User with id '{}' not found", id);
        }
        //TODO - optional change goes here
        return user;
    }

    @Override
    public List<IUser> getAll() {
        LOGGER.debug("Retrieving user data");
        return new ArrayList<>(data.values());
    }

    @Override
    public boolean save(IUser user) {
        LOGGER.debug("Attempting to save user '{}'", user);
        if (data.containsKey(user.getId())) {
            LOGGER.error("User with id '{}' already present in data", user.getId());
            return false;
        } else {
            LOGGER.info("User with id '{}' saved in data", user.getId());
            data.put(user.getId(), user);
            return true;
        }
    }

    @Override
    public boolean delete(String id) {
        if (!data.containsKey(id)) {
            LOGGER.error("User with id '{}' not found", id);
            return false;
        } else {
            LOGGER.info("Removing user with id '{}'",id);
            data.remove(id);
            return true;
        }
    }
}
