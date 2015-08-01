package com.twu.biblioteca.operation;


import com.twu.biblioteca.Library;
import com.twu.biblioteca.View;

public class Parser {

    private final Library library;
    private final View view;

    public Parser(Library library, View view) {
        this.library = library;
        this.view = view;
    }

    public Operation userInput(String input) {
        if (input.equals("0"))
            return new Quit();
        else if (input.equals("1"))
            return new ListBooks(library, view);
        else if (input.equals("2"))
            return new CheckOut(library, view);
        else if (input.equals("3"))
            return new CheckIn(library, view);
        else
            return new InvalidOption(view);
    }
}
