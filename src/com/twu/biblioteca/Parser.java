package com.twu.biblioteca;


public class Parser {
    public Operation userInput(Library library, View view, String input) {
        if(input.equals("ListBooks")) {
            return new ListBooks(library, view);
        }
        else if(input.equals("Quit")){
            return new Quit();
        }
        else
            return new InvalidOption(view);

    }
}
