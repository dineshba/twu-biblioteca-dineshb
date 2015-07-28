package com.twu.biblioteca;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        View view = new View();
        ArrayList<String> bookOne = new ArrayList<String>();
        ArrayList<String> bookTwo = new ArrayList<String>();
        bookOne.add("Java");
        bookOne.add("Author");
        bookOne.add("2009");
        bookTwo.add("C++");
        bookTwo.add("Dinesh");
        bookTwo.add("2010");
        ArrayList<ArrayList<String>> books = new ArrayList<ArrayList<String>>();
        Library library = new Library(books);
        Application application = new Application(view, library);
        application.start();
    }
}
