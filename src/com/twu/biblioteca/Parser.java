package com.twu.biblioteca;


public class Parser {
    public void userInput(Library library, View view, String input) {
        if(input.equals("ListBooks")) {
            view.show(String.format("%-15s %-15s %-10s", "BookName", "Author", "Year of Published"));
            library.giveBookTo(view);
        }
        else if(input.equals("Quit")){
            view.show("Bye");
        }
        else
            view.show("Select a valid option!");
    }
}
