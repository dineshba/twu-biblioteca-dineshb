package com.twu.biblioteca.operation;

import com.twu.biblioteca.View;
import com.twu.biblioteca.model.Library;

import java.util.HashMap;


public class Parser {
    private final Library bookLibrary;
    private final View view;
    private final Library movieLibrary;
    private final HashMap<String, Operation> commands;

    public Parser(Library bookLibrary, Library movieLibrary, View view, HashMap<String, Operation> commands) {
        this.bookLibrary = bookLibrary;
        this.movieLibrary = movieLibrary;
        this.view = view;
        this.commands = commands;
    }

    public Operation userInput(String input) {
            try {
                return commands.get(input);
            }
            catch (NullPointerException e) {
                return new InvalidOption(view);
            }
    }
}
