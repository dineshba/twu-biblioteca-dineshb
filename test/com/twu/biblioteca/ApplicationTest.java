package com.twu.biblioteca;

import com.twu.biblioteca.operation.Parser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

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
        Book bookOne = new Book("Java", "Robert", "2009");
        Book bookTwo = new Book("C++", "Dinesh", "2020");
        ArrayList<LibrarySection> books = new ArrayList<LibrarySection>();
        books.add(bookOne);
        books.add(bookTwo);
        Library library = new Library(books);
        View view = Mockito.mock(View.class);
        Parser parser = new Parser(library, library, view);
        Application application = new Application(view, library, parser);

        Mockito.when(view.getInput()).thenReturn("abc");
        application.start(false);
        Mockito.verify(view, atLeast(2)).show(any(String.class));
    }
}
