package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;


public class Main {

    public static void main(String[] args) {
        View view = new View();
        Parser parser = new Parser();
        Book bookOne = new Book("Java", "Robert", "2009");
        Book bookTwo = new Book("C++", "Dinesh", "2020");
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(bookOne);
        books.add(bookTwo);
        Library library = new Library(books);
        Application application = new Application(view, library, parser);
        application.start(true);
    }
}
