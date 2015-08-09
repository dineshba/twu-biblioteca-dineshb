package com.twu.biblioteca.operation;

import com.twu.biblioteca.Login;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.LibrarySection;
import com.twu.biblioteca.Users;
import com.twu.biblioteca.View;
import com.twu.biblioteca.reponse.Success;
import org.junit.Test;
import org.mockito.Mock;
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
        Users userOne = new Users("111-1111", "dinydiny", "User", "Dinesh", "dinesh@gmail.com", "8973882730");
        Users userTwo = new Users("111-1112", "admin", "Admin", "Babu", "babu@yahoo.com", "9791621203");
        ArrayList<Users> users = new ArrayList<>();
        users.add(userOne);
        users.add(userTwo);
        Login login = new Login(users);
        Success success = new Success();
        Library library = new Library(books, login, success);
        View view = Mockito.mock(View.class);
        CheckOut checkOut = new CheckOut(library, view, "book");

        Mockito.when(view.getInput()).thenReturn("C++");
        checkOut.execute();

        Mockito.verify(view).show("Enter the Name");
        Mockito.verify(view).show("Thank you! Enjoy the book");
    }

    @Test
    public void displayNotAvailableAsBookInCheckedOutList() {
        Book bookOne = new Book("Java", "Robert", "2009");
        Book bookTwo = new Book("C++", "Dinesh", "2020");
        ArrayList<LibrarySection> books = new ArrayList<LibrarySection>();
        books.add(bookOne);
        books.add(bookTwo);
        Users userOne = new Users("111-1111", "dinydiny", "User", "Dinesh", "dinesh@gmail.com", "8973882730");
        Users userTwo = new Users("111-1112", "admin", "Admin", "Babu", "babu@yahoo.com", "9791621203");
        ArrayList<Users> users = new ArrayList<>();
        users.add(userOne);
        users.add(userTwo);
        Success success = new Success();
        Library library = Mockito.mock(Library.class);
        View view = Mockito.mock(View.class);
        CheckOut checkOut = new CheckOut(library, view, " ");

        Mockito.when(view.getInput()).thenReturn("C++");
        Mockito.when(library.checkOut("C++")).thenReturn(null);
        checkOut.execute();

        Mockito.verify(view).show("Enter the Name");
        Mockito.verify(view).show("null ");
    }
}
