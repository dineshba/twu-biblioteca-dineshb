package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;

public class LoginTest {

    @Test
    public void shouldBeTrueWhenNamePasswordAndRollAreMatchedWithAnyUsers() {
        Users userOne = new Users("Dinesh", "dinydiny", "Customer");
        Users userTwo = new Users("Arun", "admin", "Librarian");
        ArrayList<Users> users = new ArrayList<Users>();
        users.add(userOne);
        users.add(userTwo);
        Login login = new Login(users);

        assertTrue(login.authenticate("Dinesh", "dinydiny", "Customer"));
    }
}
