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

        someNewUser = new User("Jon Snow", "snow@theblackcastle.wall", "ghost");
        form.registerUser(someNewUser);
        IUser badUser = new User("Thor", "thor@asgard.as", "");
        form.registerUser(badUser);
    }
}
