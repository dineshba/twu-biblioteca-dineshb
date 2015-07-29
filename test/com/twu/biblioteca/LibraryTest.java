package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

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
        HashMap bookOne = new HashMap();
        HashMap bookTwo = new HashMap();
        bookOne.put("bookName", "Java");
        bookOne.put("Author", "Robert");
        bookOne.put("Year of Published", "2009");
        bookTwo.put("bookName", "C++");
        bookTwo.put("Author", "Dinesh");
        bookTwo.put("Year of Published", "2010");
        ArrayList<HashMap> books = new ArrayList<HashMap>();
        books.add(bookOne);
        books.add(bookTwo);
        Library library = new Library(books);

        assertEquals(books, library.display());
    }

    @Test
    public void checkOut() {
        HashMap bookOne = new HashMap();
        HashMap bookTwo = new HashMap();
        bookOne.put("bookName", "Java");
        bookOne.put("Author", "Robert");
        bookOne.put("Year of Published", "2009");
        bookTwo.put("bookName", "C++");
        bookTwo.put("Author", "Dinesh");
        bookTwo.put("Year of Published", "2010");
        ArrayList<HashMap> books = new ArrayList<HashMap>();
        books.add(bookOne);
        books.add(bookTwo);
        Library library = new Library(books);
        View view = Mockito.mock(View.class);

        library.checkOut(view, "Java");

        Mockito.verify(view).show("Thank you! Enjoy the book");
    }
}
