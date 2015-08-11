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

import static org.junit.Assert.assertEquals;


public class MainMenuViewTest {

    @Test
    public void shouldReturnTheLoginViewForOptionOne() {
        View view = new View();
        Users userOne = new Users("111-1111", "dinydiny", "User", "Dinesh", "dinesh@gmail.com", "8973882730");
        Users userTwo = new Users("111-1112", "admin", "Admin", "Babu", "babu@yahoo.com", "9791621203");
        ArrayList<Users> users = new ArrayList<>();
        users.add(userOne);
        users.add(userTwo);
        Login login = new Login(users);

        Book bookOne = new Book("Java", "Robert", "2009");
        Book bookTwo = new Book("C++", "Dinesh", "2020");
        ArrayList<LibrarySection> books = new ArrayList<>();
        books.add(bookOne);
        books.add(bookTwo);
        SuccessCheckOut successCheckOut = new SuccessCheckOut();
        FailureCheckOut failureCheckOut = new FailureCheckOut();
        SuccessCheckIn successCheckIn = new SuccessCheckIn();
        FailureCheckIn failureCheckIn = new FailureCheckIn();
        Library bookLibrary = new Library(books, login, successCheckOut, failureCheckOut, successCheckIn, failureCheckIn);
        Movie movieOne = new Movie("Sivaji", "2009", "Sankar", "10");
        Movie movieTwo = new Movie("kaakaaMuttai", "2009", "Bala", "9");
        ArrayList<LibrarySection> movies = new ArrayList<>();
        movies.add(movieOne);
        movies.add(movieTwo);
        Library movieLibrary = new Library(movies, login, successCheckOut, failureCheckOut, successCheckIn, failureCheckIn);

        HashMap<String, Operation> librarianCommands = new HashMap<>();
        librarianCommands.put("0", new Logout(login));
        librarianCommands.put("1", new ListItems(bookLibrary, view, "Books"));
        librarianCommands.put("2", new CheckOut(bookLibrary, view, "Book"));
        librarianCommands.put("3", new CheckIn(bookLibrary, view, "Book"));
        librarianCommands.put("4", new ListItems(movieLibrary, view, "Movie"));
        librarianCommands.put("5", new CheckOut(movieLibrary, view, "Movie"));
        librarianCommands.put("6", new CheckIn(movieLibrary, view, "Movie"));
        librarianCommands.put("7", new UserInformation(view, login));
        librarianCommands.put("8", new ListCheckedOutItems(bookLibrary, view, "Books"));
        librarianCommands.put("9", new ListCheckedOutItems(movieLibrary, view, "Movies"));

        HashMap<String, Operation> customerCommands = new HashMap<>();
        customerCommands.put("0", new Logout(login));
        customerCommands.put("1", new ListItems(bookLibrary, view, "Books"));
        customerCommands.put("2", new CheckOut(bookLibrary, view, "Book"));
        customerCommands.put("3", new CheckIn(bookLibrary, view, "Book"));
        customerCommands.put("4", new ListItems(movieLibrary, view, "Movies"));
        customerCommands.put("5", new CheckOut(movieLibrary, view, "Movie"));
        customerCommands.put("6", new CheckIn(movieLibrary, view, "Movie"));
        customerCommands.put("7", new UserInformation(view, login));

        Executer executer = Mockito.mock(Executer.class);
        CustomerView customerView = new CustomerView(view, executer, customerCommands, login);
        LibrarianView librarianView = new LibrarianView(view, executer, librarianCommands, login);
        HashMap<String, IView> mainMenuCommands = new HashMap<>();
        mainMenuCommands.put("0", new QuitView());
        mainMenuCommands.put("1", new LoginView(login, view, librarianView, customerView));
        MainMenuView mainMenuView = new MainMenuView(view, mainMenuCommands, executer);

        Mockito.when(executer.executeMainMenu(view, mainMenuCommands)).thenReturn(new LoginView(login, view, librarianView, customerView));

        assertEquals(LoginView.class, mainMenuView.execute().getClass());
    }

}