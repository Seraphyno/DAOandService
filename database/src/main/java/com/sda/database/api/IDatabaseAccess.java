package com.sda.database.api;

import java.util.List;

/**
 * Interface used to access the database
 */
public interface IDatabaseAccess {

    /**
     * Query Database using user id
     * @param id unique user identifier
     * @return IUser object
     */
    IUser getById(String id);

    /**
     * Retrieve all users from database
     * @return list of users
     */
    List<IUser> getAll();

    /**
     * Saves a new user
     * @param user object to store
     * @return operation result
     */
    boolean save(IUser user);

    /**
     * Removes user
     * @param id unique user identifier
     * @return operation result
     */
    boolean delete(String id);
}
