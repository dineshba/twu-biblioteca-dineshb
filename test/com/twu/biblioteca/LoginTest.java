package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

public class LoginTest {

    @Test
    public void shouldBeTrueWhenNamePasswordAndRollAreMatchedWithAnyUsers() {
        Users userOne = new Users("Dinesh", "dinydiny", "Customer", "Dinesh", "dinesh@gmail.com", "8973882730");
        Users userTwo = new Users("Arun", "admin", "Librarian", "Dinesh", "dinesh@gmail.com", "8973882730");
        ArrayList<Users> users = new ArrayList<Users>();
        users.add(userOne);
        users.add(userTwo);
        Login login = new Login(users);

        assertEquals(userOne.getClass(), login.authenticate("Dinesh", "dinydiny", "Customer").getClass());
    }
}
