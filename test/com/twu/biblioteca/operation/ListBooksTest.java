package com.twu.biblioteca.operation;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.View;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeast;


public class ListBooksTest {

    @Test
    public void libraryShouldGiveBookToView() {
        Book bookOne = new Book("Java", "Robert", "2009");
        Book bookTwo = new Book("C++", "Dinesh", "2020");
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(bookOne);
        books.add(bookTwo);
        Library library = new Library(books);
        View view = Mockito.mock(View.class);
        ListBooks listBooks = new ListBooks(library, view);

        listBooks.execute();
        Mockito.verify(view, atLeast(2)).show(any(String.class));
    }
}