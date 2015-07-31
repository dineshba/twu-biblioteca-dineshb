package com.twu.biblioteca.operation;


import com.twu.biblioteca.Library;

public class CheckIn implements Operation {
    private final Library library;
    private String requestedBook;

    public CheckIn(Library library, String userRequestedBook) {
        this.library = library;
        this.requestedBook = userRequestedBook;
    }

    @Override
    public String execute() {
        if (library.checkIn(requestedBook)) {
            return "Thank you for returning the book";
        }
        else
            return "That is not a valid book to return";
    }
}
