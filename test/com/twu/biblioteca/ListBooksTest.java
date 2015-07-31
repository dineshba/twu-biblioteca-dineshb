package com.twu.biblioteca;

import com.twu.biblioteca.operation.ListBooks;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class ListBooksTest {

    @Test
    public void libraryShouldGiveBookToView() {
        Book bookOne = new Book("Java", "Robert", "2009");
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(bookOne);
        Library library = new Library(books);
        ListBooks listBooks = new ListBooks(library);
        String expected = String.format("%-15s %-15s %-10s", "BookName", "Author", "Year of Published");
        expected += "\n";
        expected += String.format("%-15s %-15s %-10s", "Java", "Robert", "2009");

        assertEquals(expected, listBooks.execute());
    }
}