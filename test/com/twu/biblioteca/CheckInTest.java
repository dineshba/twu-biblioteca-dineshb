package com.twu.biblioteca;

import com.twu.biblioteca.operation.CheckIn;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class CheckInTest {

    @Test
    public void shouldNotAllowToCheckInWhenCheckOutListIsEmpty() {
        Book bookOne = new Book("Java", "Robert", "2009");
        Book bookTwo = new Book("C++", "Dinesh", "2020");
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(bookOne);
        books.add(bookTwo);
        Library library = new Library(books);
        CheckIn checkIn = new CheckIn(library, "Java");

        assertEquals("That is not a valid book to return", checkIn.execute());
    }
}