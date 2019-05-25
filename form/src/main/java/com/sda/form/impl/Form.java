package com.sda.form.impl;

import java.util.Arrays;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sda.database.api.IDatabaseAccess;
import com.sda.database.api.IUser;
import com.sda.database.impl.Database;
import com.sda.form.api.IForm;
import com.sda.form.api.IGreetingService;

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
        // TODO - implementare (TEMA - 26.05?)
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
        // IUser existingUser = databaseConnection.getById(newUser.getId());
    }

    @Override
    public boolean login(String email, String password) {
        LOGGER.debug("Attempting login for user '{}'", email);
        boolean result = false;
        Optional<IUser> foundUser = databaseConnection.getById(email);

        boolean passwordsMatch = false;
        if (foundUser.isPresent()) {
            passwordsMatch = Arrays.equals(foundUser.get().getPassword(),
                    password.toCharArray());
        } else {
            LOGGER.error("User with id '{}' was not found", email);
        }

        if (passwordsMatch) {
            result = true;
            greetingService.greet(foundUser.get());
            // Greeting greeting = new Greeting();
            // greeting.greet(foundUser);
        }

        return result;
    }
}
