package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

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
        HashMap bookOne = buildBookOne();
        HashMap bookTwo = buildBookTwo();
        ArrayList<HashMap> books = buildLibrary(bookOne, bookTwo);
        Library library = new Library(books);

        assertEquals(books, library.display());
    }

    @Test
    public void checkOut() {
        HashMap bookOne = buildBookOne();
        HashMap bookTwo = buildBookTwo();
        ArrayList<HashMap> books = buildLibrary(bookOne, bookTwo);
        Library library = new Library(books);

        assertEquals(books.get(0), library.checkOut("Java"));
    }

    @Test
    public void checkIn() {
        HashMap bookOne = buildBookOne();
        HashMap bookTwo = buildBookTwo();
        ArrayList<HashMap> books = buildLibrary(bookOne, bookTwo);
        Library library = new Library(books);

        assertEquals(null, library.checkIn("Java"));
    }

    private ArrayList<HashMap> buildLibrary(HashMap bookOne, HashMap bookTwo) {
        ArrayList<HashMap> books = new ArrayList<HashMap>();
        books.add(bookOne);
        books.add(bookTwo);
        return books;
    }

    private HashMap buildBookTwo() {
        return buildBook("C++", "Dinesh", "2010");
    }

    private HashMap buildBook(String name, String author, String yearOfPublishing) {
        HashMap book = new HashMap();
        book.put("bookName", name);
        book.put("Author", author);
        book.put("Year of Published", yearOfPublishing);
        return book;
    }

    private HashMap buildBookOne() {
        return buildBook("Java", "Robert", "2009");
    }
}
