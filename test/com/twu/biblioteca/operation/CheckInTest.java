package com.twu.biblioteca.operation;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.LibrarySection;
import com.twu.biblioteca.Users;
import com.twu.biblioteca.View;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;


public class CheckInTest {

    @Test
    public void shouldNotAllowToCheckInWhenCheckOutListIsEmpty() {
        Book bookOne = new Book("Java", "Robert", "2009");
        Book bookTwo = new Book("C++", "Dinesh", "2020");
        ArrayList<LibrarySection> books = new ArrayList<LibrarySection>();
        books.add(bookOne);
        books.add(bookTwo);
        Library library = new Library(books);
        View view = Mockito.mock(View.class);
        Users user = new Users("111-1111", "dinydiny", "User", "Dinesh", "dinesh@gmail.com", "8973882730");
        CheckIn checkIn = new CheckIn(library, view, user);
        Mockito.when(view.getInput()).thenReturn("Java");

        checkIn.execute();

        Mockito.verify(view).show("That is not a valid item to return");
    }
}