package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class UsersTest {

    @Test
    public void shouldBeTrueWhenNamePasswordAndRollAreNotMatched() {
        Users user = new Users("Dinesh", "dinydiny", "Customer");

        assertFalse(user.authenticate("DineshB", "dinydiny", "Customer"));
    }

    @Test
    public void shouldBeTrueWhenNamePasswordAndRollAreMatched() {
        Users user = new Users("Dinesh", "dinydiny", "Customer");

        assertTrue(user.authenticate("Dinesh", "dinydiny", "Customer"));
    }
}
