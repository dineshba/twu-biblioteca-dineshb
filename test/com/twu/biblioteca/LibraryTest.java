package com.twu.biblioteca;


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
    public void setUpStream(){
        original = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void clearStream() {
        System.setOut(original);
    }
    @Test
    public void displayTwoBooks() {
        ArrayList<String> bookOne = new ArrayList<String>();
        ArrayList<String> bookTwo = new ArrayList<String>();
        bookOne.add("Java");
        bookOne.add("Author");
        bookOne.add("2009");
        bookTwo.add("C++");
        bookTwo.add("Dinesh");
        bookTwo.add("2010");
        ArrayList<ArrayList<String>> books = new ArrayList<ArrayList<String>>();
        books.add(bookOne);
        books.add(bookTwo);
        Library library = new Library(books);
        View view = new View();

        library.giveBookTo(view);

        assertEquals("Java Author 2009\nC++ Dinesh 2010\n", outContent.toString());
    }
}
