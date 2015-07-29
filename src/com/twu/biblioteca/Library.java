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

    public void display(View view) {
        for(HashMap oneBook : availableBooks) {
            view.showBook(oneBook);
        }
    }

    public void checkOut(View view, String userBook) {
        for (HashMap book : availableBooks) {
            if (book.get("bookName").equals(userBook)) {
                checkOutBooks.add(book);
                availableBooks.remove(book);
                view.show("Thank you! Enjoy the book");
                return;
            }
        }
        for (HashMap book : checkOutBooks) {
            if (book.get("bookName").equals(userBook)) {
                view.show("Already Checked Out");
                return;
            }
        }
        view.show("Enter the Book Name Correctly");
    }
}
