package com.twu.biblioteca;

import com.twu.biblioteca.operation.CheckOut;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class CheckOutTest {

    @Test
    public void displayAvailabilityMessageByView() {
        Book bookOne = new Book("Java", "Robert", "2009");
        Book bookTwo = new Book("C++", "Dinesh", "2020");
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(bookOne);
        books.add(bookTwo);
        Library library = new Library(books);
        CheckOut checkOut = new CheckOut(library, "C++");

        assertEquals("Thank you! Enjoy the book", checkOut.execute());
    }

    @Test
    public void displayNotAvailableAsBookInCheckedOutList() {
        Book bookOne = new Book("Java", "Robert", "2009");
        Book bookTwo = new Book("C++", "Dinesh", "2020");
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(bookOne);
        books.add(bookTwo);
        Library library = new Library(books);
        CheckOut checkOut = new CheckOut(library, "C+");

        assertEquals("That Book is not available", checkOut.execute());
    }
}
