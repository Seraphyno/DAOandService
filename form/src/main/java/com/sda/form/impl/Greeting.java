package com.sda.form.impl;

import com.sda.database.api.IUser;
import com.sda.form.api.IGreetingService;

public class Greeting implements IGreetingService {

    @Override
    public void greet(IUser user) {
        System.out.println("Hello, " + user.getName());
//        LOGGER.info("Hello, {}", user.getName());
    }
}
