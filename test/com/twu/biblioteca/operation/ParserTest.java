package com.twu.biblioteca.operation;

import com.twu.biblioteca.Model.Book;
import com.twu.biblioteca.Model.Library;
import com.twu.biblioteca.Model.LibrarySection;
import com.twu.biblioteca.View;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class ParserTest {

    @Test
    public void showTheBooksWhenUserInputIsListBook() {
        Book bookOne = new Book("Java", "Robert", "2009");
        Book bookTwo = new Book("C++", "Dinesh", "2020");
        ArrayList<LibrarySection> books = new ArrayList<LibrarySection>();
        books.add(bookOne);
        books.add(bookTwo);
        Library library = new Library(books);
        View view = new View();
        Parser parser = new Parser(library, library, view);

        assertEquals(ListItems.class, parser.userInput("1").getClass());

    }

    @Test
    public void showSelectAValidOptionForInvalidOption() {
        Book bookOne = new Book("Java", "Robert", "2009");
        Book bookTwo = new Book("C++", "Dinesh", "2020");
        ArrayList<LibrarySection> books = new ArrayList<LibrarySection>();
        books.add(bookOne);
        books.add(bookTwo);
        Library library = new Library(books);
        View view = new View();
        Parser parser = new Parser(library, library, view);

        assertEquals(InvalidOption.class, parser.userInput("InvalidOption").getClass());
    }
}
