package com.twu.biblioteca;

import java.util.ArrayList;


public class Library {
    private ArrayList<Book> availableBooks;
    private ArrayList<Book> checkOutBooks;

    public Library(ArrayList<Book> availableBooks) {
        this.availableBooks = availableBooks;
        this.checkOutBooks = new ArrayList<Book>();
    }

    public ArrayList<Book> availableBooks() {
        return availableBooks;
    }

    public Boolean checkOut(String requestedBookName) {
        for (Book book : availableBooks) {
            if (book.hasName(requestedBookName)) {
                checkOutBooks.add(book);
                availableBooks.remove(book);
                return true;
            }
        }
        return false;
    }

    public Boolean checkIn(String requestedBookName) {
        for (Book book : checkOutBooks) {
            if (book.hasName(requestedBookName)) {
                availableBooks.add(book);
                checkOutBooks.remove(book);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Book> checkedOutBooks() {
        return checkOutBooks;
    }
}
