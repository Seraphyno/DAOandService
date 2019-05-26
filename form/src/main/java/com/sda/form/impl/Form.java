package com.sda.form.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

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
        /*
         * caut in db daca exista user cu ac id daca da -> afisez mesaj eroare daca nu -> validari - email nu e null sau
         * empty string - parola nu e goala - numele nu e deja in DB (recomand metoda cu streams) apelati acel getAll(),
         * faceti un stream care mapeaza numele de user filtreaza numele lor .equals() numele de salvat -> salvez in db
         */
        Optional<IUser> existingUser = databaseConnection.getById(newUser.getId());
        boolean isSaveSuccessful = false;
        if (existingUser.isPresent()) {
            LOGGER.error("User with id '{}' already exists", newUser.getId());
        } else {
            try {
                validateUser(newUser);
                isSaveSuccessful = databaseConnection.save(newUser);
            } catch (IllegalArgumentException e) {
                LOGGER.error("Invalid input - ", e);
            }
        }
        if (isSaveSuccessful) {
            LOGGER.info("Successfully saved user with id '{}'", newUser.getId());
        } else {
            LOGGER.warn("Failed to save the user with id '{}'", newUser.getId());
        }
    }

    @Override
    public boolean login(String email, String password) {
        LOGGER.debug("Attempting login for user '{}'", email);
        boolean result = false;
        Optional<IUser> foundUser = databaseConnection.getById(email);

        boolean passwordsMatch = false;
        if (foundUser.isPresent()) {
            passwordsMatch = Arrays.equals(foundUser.get().getPassword(), password.toCharArray());
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

    private void validateUser(IUser user) throws IllegalArgumentException {
        if (!isValidEmail().test(user.getEmail())) {
            throw new IllegalArgumentException("Invalid email!");
        }
        if (!isValidPassword().test(user.getPassword())) {
            throw new IllegalArgumentException("Invalid password!");
        }
        if (nameIsTaken(user.getName())) {
            throw new IllegalArgumentException("Invalid user name!");
        }
    }

    private boolean nameIsTaken(String name) {
        Predicate<String> isSameName = existingName -> existingName.equals(name);
        List<IUser> existingUsers = databaseConnection.getAll();
        Optional<String> nameFoundOp = existingUsers.stream().map(IUser::getName).filter(isSameName).findFirst();

        return nameFoundOp.isPresent();
    }

    private Predicate<char[]> isValidPassword() {
        return password -> password != null && password.length > 0;
    }

    private Predicate<String> isValidEmail() {
        return email -> email != null && email.length() > 0 && email.contains("@");
    }
}
