package com.twu.biblioteca;


public class CheckIn implements Operation {
    private final Library library;
    private final View view;

    public CheckIn(Library library, View view) {
        this.library = library;
        this.view = view;
    }

    @Override
    public void execute() {
        view.show("Enter the book Name");
        String userBook = view.getInput();
        if (library.checkIn(userBook) != null) {
            view.show("Thank you for returning the book");
        }
        else
            view.show("That is not a valid book to return");
    }
}
