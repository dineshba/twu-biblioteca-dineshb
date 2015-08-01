package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class ParserTest {

    @Test
    public void showTheBooksWhenUserInputIsListBook() {
        Book bookOne = new Book("Java", "Robert", "2009");
        Book bookTwo = new Book("C++", "Dinesh", "2020");
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(bookOne);
        books.add(bookTwo);
        Library library = new Library(books);
        View view = new View();
        Parser parser = new Parser(library, view);

        assertEquals(ListBooks.class, parser.userInput("1").getClass());

    }

    @Test
    public void showSelectAValidOptionForInvalidOption() {
        Book bookOne = new Book("Java", "Robert", "2009");
        Book bookTwo = new Book("C++", "Dinesh", "2020");
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(bookOne);
        books.add(bookTwo);
        Library library = new Library(books);
        View view = new View();
        Parser parser = new Parser(library, view);

        assertEquals(InvalidOption.class, parser.userInput("InvalidOption").getClass());
    }
}
