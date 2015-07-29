package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;


public class Library {
    private ArrayList<HashMap> availableBooks = new ArrayList<HashMap>();
    private ArrayList<HashMap> checkOutBooks = new ArrayList<HashMap>();

    public Library(ArrayList<HashMap> availableBooks) {
        this.availableBooks = availableBooks;
    }

    public void giveBookTo(View view) {
        for(HashMap oneBook : availableBooks) {
            view.showBook(oneBook);
        }
    }

    public Boolean checkBook(String userBook) {
        for (HashMap books : availableBooks) {
            if(books.get("bookName").equals(userBook))
                return true;
        }
        return false;
    }

    public Boolean checkBookInCheckOutList(String userBook) {
        for (HashMap books : checkOutBooks) {
            if(books.get("bookName").equals(userBook))
                return true;
        }
        return false;
    }
}
