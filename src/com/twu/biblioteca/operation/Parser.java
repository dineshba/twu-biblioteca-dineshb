package com.twu.biblioteca.operation;

import com.twu.biblioteca.View;

import java.util.HashMap;


public class Parser {
    private final View view;
    private final HashMap<String, Operation> commands;

    public Parser(View view, HashMap<String, Operation> commands) {
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
