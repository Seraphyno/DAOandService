package com.sda.application;

import com.sda.database.api.IUser;
import com.sda.database.impl.User;
import com.sda.form.api.IForm;
import com.sda.form.impl.Form;

public class Main {

    public static void main(String[] args) {
        IForm form = new Form();
        IUser someNewUser;

        //todo - register a new valid user
        //todo - register an invalid user (existing)
        //todo - create a test for login functionality in form module
        //todo - cover in the test all posibilities
        //TODO - create test for database access and cover all functionalities
    }
}
