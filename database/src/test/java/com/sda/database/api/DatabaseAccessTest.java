package com.sda.database.api;

import com.sda.database.impl.Database;
import com.sda.database.impl.User;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class DatabaseAccessTest {

    private Database db = new Database();

    @Test
    public void getById() {
        Optional<IUser> userOp;
        userOp = db.getById("");
        assertFalse(userOp.isPresent());

        userOp = db.getById("root@linux.com");
        assertTrue(userOp.isPresent());
    }

    @Test
    public void getAll() {
        List<IUser> users = db.getAll();
        assertEquals(5, users.size());
    }

    @Test
    public void save() {
        List<IUser> users = db.getAll();
        assertEquals(5, users.size());

        IUser user = new User("Black Widow", "black-widow@avengers.com", "hulkSmash!");
        boolean saved = db.save(user);
        assertTrue(saved);
        assertEquals(6, db.getAll().size());

        saved = db.save(user);
        assertFalse(saved);
    }

    @Test
    public void delete() {
        assertEquals(5, db.getAll().size());

        boolean deleted = db.delete("root@linux.com");
        assertTrue(deleted);

        assertEquals(4, db.getAll().size());

        deleted = db.delete("");
        assertFalse(deleted);
    }
}