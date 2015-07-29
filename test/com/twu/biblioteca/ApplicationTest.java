package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import static org.mockito.Matchers.any;
import static org.mockito.internal.verification.VerificationModeFactory.atLeast;


public class ApplicationTest {

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
        HashMap bookOne = buildBookOne();
        HashMap bookTwo = buildBookTwo();
        Library library = buildLibrary(bookOne, bookTwo);
        Parser parser = new Parser();
        View view = Mockito.mock(View.class);
        Application application = new Application(view, library, parser);

        Mockito.when(view.getInput()).thenReturn("abc");
        application.start(false);
        Mockito.verify(view, atLeast(2)).show(any(String.class));
    }

    private Library buildLibrary(HashMap bookOne, HashMap bookTwo) {
        ArrayList<HashMap> books = new ArrayList<HashMap>();
        books.add(bookOne);
        books.add(bookTwo);
        return new Library(books);
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
