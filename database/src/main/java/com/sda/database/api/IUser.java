package com.sda.database.api;

import java.time.LocalDateTime;

/**
 * User object representation
 */
public interface IUser {

    String getId();

    String getName();

    String getEmail();

    char[] getPassword();

    LocalDateTime getTimeCreated();
}
