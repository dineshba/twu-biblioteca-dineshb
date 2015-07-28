package com.twu.biblioteca;

import java.util.HashMap;


public class View {

    public void welcomeMessage() {
        System.out.println("Welcome");
    }

    public void showBooks(HashMap book) {
        System.out.println(book.get("bookName") + " " + book.get("Author") + " " + book.get("Year of Published"));
    }
}
