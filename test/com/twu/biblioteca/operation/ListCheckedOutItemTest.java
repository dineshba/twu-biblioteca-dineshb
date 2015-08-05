package com.twu.biblioteca.operation;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.LibrarySection;
import com.twu.biblioteca.Users;
import com.twu.biblioteca.View;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeast;

public class ListCheckedOutItemTest {

    @Test
    public void shouldDisplayTheCheckedOutBookLists() {
        Book bookOne = new Book("Java", "Robert", "2009");
        Book bookTwo = new Book("C++", "Dinesh", "2020");
        ArrayList<LibrarySection> books = new ArrayList<LibrarySection>();
        books.add(bookOne);
        books.add(bookTwo);
        Library library = new Library(books);
        View view = Mockito.mock(View.class);
        Users user = new Users("111-1111", "dinydiny", "User", "Dinesh", "dinesh@gmail.com", "8973882730");
        CheckOut checkOut = new CheckOut(library, view, user);
        ListCheckedOutItems listCheckedOutItems = new ListCheckedOutItems(library, view);
        checkOut.execute();
        Mockito.when(view.getInput()).thenReturn("Java");

        listCheckedOutItems.execute();
        Mockito.verify(view, atLeast(2)).show(any(String.class));
    }

}