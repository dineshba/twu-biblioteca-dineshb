package com.twu.biblioteca.operation;


import com.twu.biblioteca.Library;

public class CheckOut implements Operation {
    private final Library library;
    private String requestedBook;

    public CheckOut(Library library, String requestedBook) {
        this.library = library;
        this.requestedBook = requestedBook;
    }

    @Override
    public String  execute() {
        if (library.checkOut(requestedBook))
            return "Thank you! Enjoy the book";
        else
            return "That Book is not available";
    }
}
