package com.sda.form.api;

import com.sda.database.api.IUser;

/**
 * Service which greets the users after login
 */
@FunctionalInterface
public interface IGreetingService {

    /**
     * Method used to greet the given user
     * @param user target for greeting
     */
    void greet(IUser user);
}
