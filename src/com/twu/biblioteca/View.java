package com.twu.biblioteca;


import java.util.ArrayList;

public class View {

    public void welcomeMessage() {
        System.out.println("Welcome");
    }

    public void showBooks(ArrayList<String> book) {
        System.out.println(book.get(0) + " " + book.get(1) + " " + book.get(2));
    }
}
