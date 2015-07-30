package com.twu.biblioteca;


public class CheckOut implements Operation {
    private final Library library;
    private final View view;

    public CheckOut(Library library, View view) {
        this.view = view;
        this.library = library;
    }

    @Override
    public void execute() {
        view.show("Enter the Book Name");
        String userBook = view.getInput();
        if (library.checkOut(userBook))
            view.show("Thank you! Enjoy the book");
        else
            view.show("That Book is not available");
    }
}
