package com.twu.biblioteca.view;

import com.twu.biblioteca.helper.Executer;
import com.twu.biblioteca.helper.Login;
import com.twu.biblioteca.model.Users;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.LibrarySection;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.operation.*;
import com.twu.biblioteca.reponse.FailureCheckIn;
import com.twu.biblioteca.reponse.FailureCheckOut;
import com.twu.biblioteca.reponse.SuccessCheckIn;
import com.twu.biblioteca.reponse.SuccessCheckOut;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;

import static junit.framework.TestCase.assertNull;


public class CustomerViewTest {

    @Test
    public void shouldReturnMainView() {
        View view = Mockito.mock(View.class);
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
        Library bookLibrary = new Library(books, login, successCheckOut, failureCheckOut, successCheckIn, failureCheckIn);
        Movie movieOne = new Movie("Sivaji", "2009", "Sankar", "10");
        Movie movieTwo = new Movie("kaakaaMuttai", "2009", "Bala", "9");
        ArrayList<LibrarySection> movies = new ArrayList<LibrarySection>();
        movies.add(movieOne);
        movies.add(movieTwo);
        Library movieLibrary = new Library(movies, login, successCheckOut, failureCheckOut, successCheckIn, failureCheckIn);

        HashMap<String, Operation> customerCommands = new HashMap<>();
        customerCommands.put("1", new ListItems(bookLibrary, view, "List Books"));
        customerCommands.put("2", new CheckOut(bookLibrary, view, "CheckOut Book"));
        customerCommands.put("3", new CheckIn(bookLibrary, view, "CheckIn Book"));
        customerCommands.put("4", new ListItems(movieLibrary, view, "List Movies"));
        customerCommands.put("5", new CheckOut(movieLibrary, view, "CheckOut Movie"));
        customerCommands.put("6", new CheckIn(movieLibrary, view, "CheckIn Movie"));
        customerCommands.put("7", new UserInformation(view, login));

        Executer executer = new Executer(new InvalidOption(view));
        CustomerView customerView = new CustomerView(view, executer, customerCommands, login);

        Mockito.when(view.getInput()).thenReturn("1");

        assertNull(customerView.execute());
    }
}