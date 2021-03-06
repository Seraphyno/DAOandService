package com.sda.form.impl;

import com.sda.database.impl.Database;
import com.sda.form.api.IGreetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sda.database.api.IDatabaseAccess;
import com.sda.database.api.IUser;
import com.sda.form.api.IForm;

import java.util.Arrays;

public class Form implements IForm {

    private static final Logger LOGGER = LoggerFactory.getLogger(Form.class);
    private IDatabaseAccess databaseConnection;
    private IGreetingService greetingService = user -> LOGGER.info("Hello, {}", user.getName());

    public Form() {
        databaseConnection = new Database();
    }

    @Override
    public void registerUser(IUser newUser) {
        LOGGER.debug("Registering a new user, with id '{}'", newUser.getId());
        IUser existingUser = databaseConnection.getById(newUser.getId());
        //todo - implement the rest of the method
        /*caut in db daca exista user cu ac id
        // daca da -> afisez mesaj eroare
        //daca nu -> validari
        //              - email nu e null sau empty string
        //              - parola nu e goala
        //              - numele nu e deja in DB (recomand metoda cu streams)
                        apelati acel getAll(), faceti un stream care
                            mapeaza numele de user
                            filtreaza numele lor .equals() numele de salvat
        //          -> salvez in db
        */
    }

    @Override
    public boolean login(String email, String password) {
        LOGGER.debug("Attempting login for user '{}'", email);
        boolean result = false;
        IUser foundUser = databaseConnection.getById(email);

        //todo - this should throw NPE - migrate to Optionals
        boolean passwordsMatch = Arrays.equals(foundUser.getPassword(), password.toCharArray());

        if (passwordsMatch) {
            result = true;
            greetingService.greet(foundUser);
        }

        return result;
    }
}
