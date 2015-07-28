package com.twu.biblioteca;

import java.util.ArrayList;


public class Library {
    private ArrayList<String> Book = new ArrayList<String>();

    public Library() {
        Book.add("Java");
    }

    public void giveBookTo(View view) {
        view.showBooks(Book.get(0));
    }
}
