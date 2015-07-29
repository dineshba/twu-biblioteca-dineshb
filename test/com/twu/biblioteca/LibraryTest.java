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
        ArrayList<HashMap> books = buildBook();
        Library library = new Library(books);

        assertEquals(books, library.display());
    }

    @Test
    public void checkOut() {
        ArrayList<HashMap> books = buildBook();
        Library library = new Library(books);

        assertEquals(books.get(0), library.checkOut("Java"));
    }

    @Test
    public void checkIn() {
        ArrayList<HashMap> books = buildBook();
        Library library = new Library(books);

        assertEquals(null, library.checkIn("Java"));
    }
    private ArrayList<HashMap> buildBook() {
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
        return books;
    }
}
