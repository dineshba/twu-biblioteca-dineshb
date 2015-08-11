package com.twu.biblioteca.operation;

import com.twu.biblioteca.helper.Login;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.LibrarySection;
import com.twu.biblioteca.model.Users;
import com.twu.biblioteca.view.View;
import com.twu.biblioteca.reponse.FailureCheckIn;
import com.twu.biblioteca.reponse.FailureCheckOut;
import com.twu.biblioteca.reponse.SuccessCheckIn;
import com.twu.biblioteca.reponse.SuccessCheckOut;
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
        Users userOne = new Users("111-1111", "dinydiny", "User", "Dinesh", "dinesh@gmail.com", "8973882730");
        Users userTwo = new Users("111-1112", "admin", "Admin", "Babu", "babu@yahoo.com", "9791621203");
        ArrayList<Users> users = new ArrayList<>();
        users.add(userOne);
        users.add(userTwo);
        Login login = new Login(users);
        SuccessCheckOut successCheckOut = new SuccessCheckOut();
        FailureCheckOut failureCheckOut = new FailureCheckOut();
        SuccessCheckIn successCheckIn = new SuccessCheckIn();
        FailureCheckIn failureCheckIn = new FailureCheckIn();
        Library library = new Library(books, login, successCheckOut, failureCheckOut, successCheckIn, failureCheckIn);
        View view = Mockito.mock(View.class);
        CheckOut checkOut = new CheckOut(library, view, " ");
        ListCheckedOutItems listCheckedOutItems = new ListCheckedOutItems(library, view, " ");
        checkOut.execute();
        Mockito.when(view.getInput()).thenReturn("Java");

        listCheckedOutItems.execute();
        Mockito.verify(view, atLeast(2)).show(any(String.class));
    }

}