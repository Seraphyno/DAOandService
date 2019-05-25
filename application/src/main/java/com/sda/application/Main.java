package com.sda.application;

import com.sda.database.api.IUser;
import com.sda.database.impl.User;
import com.sda.form.api.IForm;
import com.sda.form.impl.Form;

public class Main {

    public static void main(String[] args) {
        IForm form = new Form();
        IUser someNewUser;

        form.login("thor@asgard.as" , "Mjolnir");
        form.login("" , "");

        //todo - register a new valid user (TEMA 26.05)
        //todo - register an invalid user (existing) (TEMA 26.05)

        //todo - create a test for login functionality in form module (TEMA 8.06)
        //todo - cover in the test all posibilities (TEMA 8.06)
        //TODO - create test for database access and cover all functionalities (TEMA 8.06)
    }
}
