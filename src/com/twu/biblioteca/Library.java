package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;


public class Library {
    private ArrayList<HashMap> books = new ArrayList<HashMap>();

    public Library(ArrayList<HashMap> books) {
        this.books = books;
    }

    public void giveBookTo(View view) {
        for(HashMap oneBook : books) {
            view.showBooks(oneBook);
        }
    }
}
