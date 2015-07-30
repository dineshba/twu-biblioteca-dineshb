package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;


public class Library {
    private ArrayList<HashMap> availableBooks;
    private ArrayList<HashMap> checkOutBooks;

    public Library(ArrayList<HashMap> availableBooks) {
        this.availableBooks = availableBooks;
        this.checkOutBooks = new ArrayList<HashMap>();
    }

    public ArrayList<HashMap> availableBooks() {
        return availableBooks;
    }

    public HashMap checkOut(String requestedBookName) {
        for (HashMap book : availableBooks) {
            //book.hasName(requestedBookName)
            if (book.get("bookName").equals(requestedBookName)) {
                checkOutBooks.add(book);
                availableBooks.remove(book);
                return book;
            }
        }
        return null;
    }

    public HashMap checkIn(String userBook) {
        for (HashMap book : checkOutBooks) {
            if (book.get("bookName").equals(userBook)) {
                checkOutBooks.remove(book);
                availableBooks.add(book);
                return book;
            }
        }
        return null;
    }
}
