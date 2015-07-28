package com.twu.biblioteca;


public class Main {

    public static void main(String[] args) {
        StartUp start = new StartUp();
        Book book = new Book();
        Application application = new Application(start, book);
        application.start();
    }
}
