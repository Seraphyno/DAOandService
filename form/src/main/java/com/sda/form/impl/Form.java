package com.sda.form.impl;

import com.sda.database.impl.Database;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sda.database.api.IDatabaseAccess;
import com.sda.database.api.IUser;
import com.sda.form.api.IForm;

import java.util.Arrays;

public class Form implements IForm {

    private static final Logger LOGGER = LoggerFactory.getLogger(Form.class);
    private IDatabaseAccess databaseConnection;
    private IUser user;

    public Form() {
        databaseConnection = new Database();
    }

    @Override
    public void registerUser(IUser newUser) {

    }

    @Override
    public boolean login(String email, String password) {
        LOGGER.debug("Attempting login for user '{}'", email);
        IUser foundUser = databaseConnection.getById(email);

        //todo - this should throw NPE - migrate to Optionals
        return Arrays.equals(foundUser.getPassword(), password.toCharArray());
    }
}
