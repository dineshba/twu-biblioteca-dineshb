package com.twu.biblioteca;

import java.util.ArrayList;


public class Library {
    private ArrayList<ArrayList<String>> books = new ArrayList<ArrayList<String>>();

    public Library(ArrayList<ArrayList<String>> books) {
        this.books = books;
    }

    public void giveBookTo(View view) {
        for(ArrayList<String> oneBook : books) {
            view.showBooks(oneBook);
        }
    }
}
