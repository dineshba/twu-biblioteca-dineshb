package com.twu.biblioteca.operation;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.LibrarySection;
import com.twu.biblioteca.Users;
import com.twu.biblioteca.View;
import com.twu.biblioteca.model.Movie;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;


public class ParserTest {

    @Test
    public void showTheBooksWhenUserInputIsListBook() {
        View view = new View();
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
        Parser customerParser = new Parser(bookLibrary, movieLibrary, view, customerCommands);
        Parser parser = new Parser(bookLibrary, movieLibrary, view, customerCommands);

        assertEquals(ListItems.class, parser.userInput("1").getClass());

    }

    @Test
    public void showSelectAValidOptionForInvalidOption() {
        View view = new View();
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
        Parser customerParser = new Parser(bookLibrary, movieLibrary, view, customerCommands);
        Parser parser = new Parser(bookLibrary, movieLibrary, view, customerCommands);

        assertEquals(InvalidOption.class, parser.userInput("InvalidOption").getClass());
    }
}
