package com.twu.biblioteca;


public class Main {

    public static void main(String[] args) {
        View view = new View();
        Library library = new Library();
        Application application = new Application(view, library);
        application.start();
    }
}
