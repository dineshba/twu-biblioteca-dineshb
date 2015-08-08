package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.LibrarySection;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.operation.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class WelcomeViewTest {

    @Test
    public void shouldReturnTheLoginView() {
        View view = new View();
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
        Library bookLibrary = new Library(books, login);
        Movie movieOne = new Movie("Sivaji", "2009", "Sankar", "10");
        Movie movieTwo = new Movie("kaakaaMuttai", "2009", "Bala", "9");
        ArrayList<LibrarySection> movies = new ArrayList<LibrarySection>();
        movies.add(movieOne);
        movies.add(movieTwo);
        Library movieLibrary = new Library(movies, login);

        HashMap<String, Operation> librarianCommands = new HashMap<>();
        librarianCommands.put("1", new ListItems(bookLibrary, view, "List Books"));
        librarianCommands.put("2", new CheckOut(bookLibrary, view, "CheckOut Books"));
        librarianCommands.put("3", new CheckIn(bookLibrary, view, "CheckIn Books"));
        librarianCommands.put("4", new ListItems(movieLibrary, view, "ListMovies"));
        librarianCommands.put("5", new CheckOut(movieLibrary, view, "CheckOut Movie"));
        librarianCommands.put("6", new CheckIn(movieLibrary, view, "CheckIn Movie"));
        librarianCommands.put("7", new UserInformation(view, login));
        librarianCommands.put("8", new ListCheckedOutItems(bookLibrary, view, "List Checked Out Books"));
        librarianCommands.put("9", new ListCheckedOutItems(movieLibrary, view, "List Checked Out Movies"));

        HashMap<String, Operation> customerCommands = new HashMap<>();
        customerCommands.put("1", new ListItems(bookLibrary, view, "List Books"));
        customerCommands.put("2", new CheckOut(bookLibrary, view, "CheckOut Book"));
        customerCommands.put("3", new CheckIn(bookLibrary, view, "CheckIn Book"));
        customerCommands.put("4", new ListItems(movieLibrary, view, "List Movies"));
        customerCommands.put("5", new CheckOut(movieLibrary, view, "CheckOut Movie"));
        customerCommands.put("6", new CheckIn(movieLibrary, view, "CheckIn Movie"));
        customerCommands.put("7", new UserInformation(view, login));

        Executer executer = new Executer(new InvalidOption(view));
        UserView userView = new UserView(view, executer, customerCommands, login);
        LibraryView libraryView = new LibraryView(view, executer, librarianCommands, login);
        LoginView loginView = new LoginView(login, view, libraryView, userView);
        MainMenuView mainMenuView = new MainMenuView(view, loginView);
        WelcomeView welcomeView = new WelcomeView(mainMenuView);

        assertEquals(loginView.getClass(), welcomeView.execute().getClass());
    }

}