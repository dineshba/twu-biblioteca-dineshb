package com.twu.biblioteca.Model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class BookTest {

    @Test
    public void compareTheBookName() {
        Book book = new Book("C++", "Dinesh", "2020");

        assertEquals(true, book.hasName("C++"));
    }
}
