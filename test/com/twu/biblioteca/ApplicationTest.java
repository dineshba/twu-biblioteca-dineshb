package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.LibrarySection;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.operation.*;
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
        View view = Mockito.mock(View.class);
        Book bookOne = new Book("Java", "Robert", "2009");
        Book bookTwo = new Book("C++", "Dinesh", "2020");
        ArrayList<LibrarySection> books = new ArrayList<LibrarySection>();
        books.add(bookOne);
        books.add(bookTwo);
        Library bookLibrary = new Library(books);
        Movie movieOne = new Movie("Sivaji", "2009", "Sankar", "10");
        Movie movieTwo = new Movie("kaakaaMuttai", "2009", "Bala", "9");
        ArrayList<LibrarySection> movies = new ArrayList<LibrarySection>();
        movies.add(movieOne);
        movies.add(movieTwo);
        Library movieLibrary = new Library(movies);
        Users user = new Users("111-1111", "dinydiny", "User", "Dinesh", "dinesh@gmail.com", "8973882730");
        ArrayList<Users> users = new ArrayList<Users>();
        users.add(user);
        HashMap<String, Operation> customerCommands = new HashMap<String, Operation>();
        customerCommands.put("1", new ListItems(bookLibrary, view));
        customerCommands.put("2", new CheckOut(bookLibrary, view, user));
        customerCommands.put("3", new CheckIn(bookLibrary, view, user));
        customerCommands.put("4", new ListItems(movieLibrary, view));
        customerCommands.put("5", new CheckOut(movieLibrary, view, user));
        customerCommands.put("6", new CheckIn(movieLibrary, view, user));
        customerCommands.put("7", new UserInformation(view, user));
        customerCommands.put("8", new ListCheckedOutItems(bookLibrary, view));
        customerCommands.put("9", new ListCheckedOutItems(movieLibrary, view));
        Parser parser = new Parser(bookLibrary, movieLibrary, view, customerCommands);

        Login login = new Login(users);
        Application application = new Application(view, parser, login);

        Mockito.when(view.getInput()).thenReturn("abc");
        application.start(false);
        Mockito.verify(view, atLeast(1)).show(any(String.class));
    }
}
