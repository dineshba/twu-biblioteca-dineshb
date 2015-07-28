package com.twu.biblioteca;

import java.util.ArrayList;


public class Library {
    private ArrayList<String> book = new ArrayList<String>();

    public Library() {
        book.add("Java");
        book.add("Basics of C");
    }

    public void giveBookTo(View view) {
        for(String oneBook : this.book)
        view.showBooks(oneBook);
    }
}
