package com.twu.biblioteca;


public class Parser {
    public Operation userInput(Library library, View view, String input) {
        if (input.equals("ListBooks")) {
            return new ListBooks(library, view);
        }
        else if (input.equals("Quit")){
            return new Quit();
        }
        else if (input.equals("CheckOut"))
            return new CheckOut(library, view);
        else if (input.equals("CheckIn"))
            return new CheckIn(library, view);
        else
            return new InvalidOption(view);
    }
}
