package com.twu.biblioteca.operation;


import com.twu.biblioteca.Library;
import com.twu.biblioteca.View;

public class Parser {

    private final View view;
    private final Library library;

    public Parser(Library library, View view) {
        this.library = library;
        this.view = view;
    }

    public Operation userInput(String input) {
        if (input.equals("0")) {
            return new Quit();
        }
        else if (input.equals("1")) {
            return new ListBooks(library);
        }
        else if (input.equals("2")) {
            view.show("Enter the book name");
            String userBook = view.getInput();
            return new CheckOut(library, userBook);
        }
        else if (input.equals("3")) {
            view.show("Enter the book name");
            String userBook = view.getInput();
            return new CheckIn(library, userBook);
        }
        else
            return new InvalidOption();
    }
}
