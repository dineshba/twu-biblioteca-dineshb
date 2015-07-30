package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;


public class BookTest {

    @Test
    public void compareWithNull() {
        Book bookOne = new Book("C++", "Dinesh", "2020");

        assertNotEquals(bookOne, null);
    }

    @Test
    public void compareTwoDifferentBooks() {
        Book bookOne = new Book("C++", "Dinesh", "2020");
        Book bookTwo = new Book("C++", "Dinesh", "2020");

        assertNotEquals(bookOne, bookTwo);
    }
}
