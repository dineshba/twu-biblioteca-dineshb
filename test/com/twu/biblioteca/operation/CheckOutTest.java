package com.twu.biblioteca.operation;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.LibrarySection;
import com.twu.biblioteca.Users;
import com.twu.biblioteca.View;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;


public class CheckOutTest {

    @Test
    public void displayAvailabilityMessageByView() {
        Book bookOne = new Book("Java", "Robert", "2009");
        Book bookTwo = new Book("C++", "Dinesh", "2020");
        ArrayList<LibrarySection> books = new ArrayList<LibrarySection>();
        books.add(bookOne);
        books.add(bookTwo);
        Library library = new Library(books);
        View view = Mockito.mock(View.class);
        Users user = new Users("111-1111", "dinydiny", "User", "Dinesh", "dinesh@gmail.com", "8973882730");
        CheckOut checkOut = new CheckOut(library, view, user);

        Mockito.when(view.getInput()).thenReturn("C++");
        checkOut.execute();

        Mockito.verify(view).show("Thank you! Enjoy");
    }

    @Test
    public void displayNotAvailableAsBookInCheckedOutList() {
        Book bookOne = new Book("Java", "Robert", "2009");
        Book bookTwo = new Book("C++", "Dinesh", "2020");
        ArrayList<LibrarySection> books = new ArrayList<LibrarySection>();
        books.add(bookOne);
        books.add(bookTwo);
        Library library = new Library(books);
        View view = Mockito.mock(View.class);
        Users user = new Users("111-1111", "dinydiny", "User", "Dinesh", "dinesh@gmail.com", "8973882730");
        CheckOut checkOut = new CheckOut(library, view, user);

        Mockito.when(view.getInput()).thenReturn("C");
        checkOut.execute();

        Mockito.verify(view).show("That requested item is not availableDetails");
    }
}
