package com.sda.database.impl;

import static com.sda.database.impl.DatabaseData.buildDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.sda.database.api.IDatabaseAccess;
import com.sda.database.api.IUser;
import com.sun.istack.internal.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Database implements IDatabaseAccess {

    private static final Logger LOGGER = LoggerFactory.getLogger(Database.class);
    private Map<String, IUser> database = buildDatabase();

    @Override
    public Optional<IUser> getById(String id) {
        LOGGER.debug("Getting user with id '{}'", id);
        IUser user = null;
        if (database.containsKey(id)) {
            LOGGER.info("Found user with id '{}'", id);
            user = database.get(id);
        } else {
            LOGGER.warn("User with id '{}' not found", id);
        }

        return Optional.ofNullable(user);
    }

    @Override
    public List<IUser> getAll() {
        LOGGER.debug("Retrieving user database");
        return new ArrayList<>(database.values());
    }

    @Override
    public boolean save(IUser user) {
        LOGGER.debug("Attempting to save user '{}'", user);
        if (database.containsKey(user.getId())) {
            LOGGER.error("User with id '{}' already present in database", user.getId());
            return false;
        } else {
            LOGGER.info("User with id '{}' saved in database", user.getId());
            database.put(user.getId(), user);
            return true;
        }
    }

    @Override
    public boolean delete(String id) {
        if (!database.containsKey(id)) {
            LOGGER.error("User with id '{}' not found", id);
            return false;
        } else {
            LOGGER.info("Removing user with id '{}'",id);
            database.remove(id);
            return true;
        }
    }
}
