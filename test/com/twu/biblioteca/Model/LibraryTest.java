package com.twu.biblioteca.Model;

import com.twu.biblioteca.Users;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class LibraryTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream original;

    @Before
    public void setUpStream() {
        original = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void clearStream() {
        System.setOut(original);
    }

    @Test
    public void displayTwoBooks() {
        Book bookOne = new Book("Java", "Robert", "2009");
        Book bookTwo = new Book("C++", "Dinesh", "2020");
        ArrayList<LibrarySection> books = new ArrayList<LibrarySection>();
        books.add(bookOne);
        books.add(bookTwo);
        Library library = new Library(books);

        assertEquals(String.format("%-15s %-15s %-15s\n%-15s %-15s %-15s\n", "Java", "Robert", "2009", "C++", "Dinesh", "2020"), library.availableDetails());
    }

    @Test
    public void checkOut() {
        Book bookOne = new Book("Java", "Robert", "2009");
        Book bookTwo = new Book("C++", "Dinesh", "2020");
        ArrayList<LibrarySection> books = new ArrayList<LibrarySection>();
        books.add(bookOne);
        books.add(bookTwo);
        Library library = new Library(books);
        Users user = new Users("111-1111", "dinydiny", "User");

        assertEquals(true, library.checkOut("Java", user));
    }

    @Test
    public void checkIn() {
        Book bookOne = new Book("Java", "Robert", "2009");
        Book bookTwo = new Book("C++", "Dinesh", "2020");
        ArrayList<LibrarySection> books = new ArrayList<LibrarySection>();
        books.add(bookOne);
        books.add(bookTwo);
        Library library = new Library(books);

        assertEquals(false, library.checkIn("Java", new Users("", "", "")));
    }
}
