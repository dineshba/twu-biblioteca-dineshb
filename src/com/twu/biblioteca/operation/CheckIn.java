package com.twu.biblioteca.operation;

import com.twu.biblioteca.Model.Library;
import com.twu.biblioteca.View;


public class CheckIn implements Operation {
    private final Library library;
    private final View view;

    public CheckIn(Library library, View view) {
        this.library = library;
        this.view = view;
    }

    @Override
    public void execute() {
        view.show("Enter the Name");
        String userBook = view.getInput();
        if (library.checkIn(userBook)) {
            view.show("Thank you for returning");
        }
        else
            view.show("That is not a valid item to return");
    }
}
