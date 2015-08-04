package com.twu.biblioteca;

import com.twu.biblioteca.Model.Book;
import com.twu.biblioteca.Model.Library;
import com.twu.biblioteca.Model.LibrarySection;
import com.twu.biblioteca.Model.Movie;
import com.twu.biblioteca.operation.Parser;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        View view = new View();
        Book bookOne = new Book("Java", "Robert", "2009");
        Book bookTwo = new Book("C++", "Dinesh", "2020");
        ArrayList<LibrarySection> books = new ArrayList<LibrarySection>();
        books.add(bookOne);
        books.add(bookTwo);
        Library bookLibrary = new Library(books);
        Movie movieOne = new Movie("Sivaji", "2009", "Sankar", "10");
        Movie movieTwo = new Movie("kaakaaMuttai", "2009", "Bala", "9");
        ArrayList<LibrarySection> movies = new ArrayList<LibrarySection>();
        movies.add(movieOne);
        movies.add(movieTwo);
        Library movieLibrary = new Library(movies);
        Parser parser = new Parser(bookLibrary, movieLibrary, view);
        Users userOne = new Users("111-1111", "dinydiny", "Customer");
        Users userTwo = new Users("111-1112", "admin", "Librarian");
        ArrayList<Users> users = new ArrayList<Users>();
        users.add(userOne);
        users.add(userTwo);
        Login login = new Login(users);
        Application application = new Application(view, bookLibrary, parser, login);
        application.start(true);
    }
}
