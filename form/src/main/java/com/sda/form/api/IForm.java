package com.sda.form.api;

import com.sda.database.api.IUser;

/**
 * Describes a login form behavior
 */
public interface IForm {

    /**
     * Create a new user
     * @param user details for the new user
     */
    void registerUser(IUser user);

    /**
     * Access the account
     * @param email the email used to register
     * @param password user's password
     * @return true if the credentials are ok
     */
    boolean login(String email, String password);

}
