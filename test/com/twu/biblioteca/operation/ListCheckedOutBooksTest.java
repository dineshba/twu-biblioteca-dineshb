package com.twu.biblioteca.operation;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.LibrarySection;
import com.twu.biblioteca.View;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeast;

public class ListCheckedOutBooksTest {

    @Test
    public void shouldDisplayTheCheckedOutBookLists() {
        Book bookOne = new Book("Java", "Robert", "2009");
        Book bookTwo = new Book("C++", "Dinesh", "2020");
        ArrayList<LibrarySection> books = new ArrayList<LibrarySection>();
        books.add(bookOne);
        books.add(bookTwo);
        Library library = new Library(books);
        View view = Mockito.mock(View.class);
        CheckOut checkOut = new CheckOut(library, view);
        ListCheckedOutBooks listCheckedOutBooks = new ListCheckedOutBooks(library, view);
        checkOut.execute();
        Mockito.when(view.getInput()).thenReturn("Java");

        listCheckedOutBooks.execute();
        Mockito.verify(view, atLeast(3)).show(any(String.class));
    }

}