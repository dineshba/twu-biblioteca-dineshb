package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.LibrarySection;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.operation.*;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;

import static junit.framework.TestCase.assertNull;

public class LibraryViewTest {

    @Test
    public void shouldReturnMainView() {
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

        Users userOne = new Users("111-1111", "dinydiny", "User", "Dinesh", "dinesh@gmail.com", "8973882730");
        Users userTwo = new Users("111-1112", "admin", "Admin", "Babu", "babu@yahoo.com", "9791621203");
        ArrayList<Users> users = new ArrayList<Users>();
        users.add(userOne);
        users.add(userTwo);

        HashMap<String, Operation> librarianCommands = new HashMap<String, Operation>();
        librarianCommands.put("1", new ListItems(bookLibrary, view));
        librarianCommands.put("2", new CheckOut(bookLibrary, view, userOne));
        librarianCommands.put("3", new CheckIn(bookLibrary, view, userOne));
        librarianCommands.put("4", new ListItems(movieLibrary, view));
        librarianCommands.put("5", new CheckOut(movieLibrary, view, userOne));
        librarianCommands.put("6", new CheckIn(movieLibrary, view, userOne));
        librarianCommands.put("7", new UserInformation(view, userOne));
        librarianCommands.put("8", new ListCheckedOutItems(bookLibrary, view));
        librarianCommands.put("9", new ListCheckedOutItems(movieLibrary, view));

        Parser librarianParser = new Parser(view, librarianCommands);


        UserView userView = new UserView(view, librarianParser);

        Mockito.when(view.getInput()).thenReturn("1");

        assertNull(userView.execute());
    }

}