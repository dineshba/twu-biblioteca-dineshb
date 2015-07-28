package com.twu.biblioteca;


public class Parser {
    public void userInput(Library library, View view, String input) {
        if(input.equals("List Books"))
            library.giveBookTo(view);
    }
}
