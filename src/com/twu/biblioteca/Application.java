package com.twu.biblioteca;

public class Application {

    private StartUp startUp;
    private Book book;

    public Application(StartUp startUp, Book book) {
        this.startUp = startUp;
        this.book = book;
    }

    public void start() {
        startUp.welcomeMessage();
        book.display();
    }
}
