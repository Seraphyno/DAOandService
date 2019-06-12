package com.sda.form.api;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sda.database.api.IUser;
import com.sda.database.impl.User;
import com.sda.form.impl.Form;

public class FormTest {

    private Form target = new Form();
    private IUser validUser = getValidUser();
    private IUser invalidUser = getInvalidUser();

    @Test
    public void testRegisterValidUser() {
        target.registerUser(validUser);
    }

    @Test
    public void testRegisterInvalidUser() {
        target.registerUser(invalidUser);
    }

    @Test
    public void testValidLogin() {
        boolean login = target.login("root@linux.com", "root");
        assertTrue(login);
    }

    @Test
    public void testInvalidLogin() {
        boolean login = target.login("toor@linux.com", "root");
        assertFalse(login);
    }

    private IUser getInvalidUser() {
        return new User("root", "root@linux.com", "root");
    }

    private IUser getValidUser() {
        return new User("root-user", "root-user@linux.com", "root");
    }
}