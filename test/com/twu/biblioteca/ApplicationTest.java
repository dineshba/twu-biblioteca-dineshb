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
        ArrayList<HashMap> books = buildBooks();
        Library library = new Library(books);
        Parser parser = new Parser();
        View view = Mockito.mock(View.class);
        Application application = new Application(view, library, parser);

        Mockito.when(view.getInput()).thenReturn("abc");
        application.start(false);
        Mockito.verify(view, atLeast(2)).show(any(String.class));
    }

    private ArrayList<HashMap> buildBooks() {
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
