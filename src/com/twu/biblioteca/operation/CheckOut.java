package com.twu.biblioteca.operation;

import com.twu.biblioteca.Model.Library;
import com.twu.biblioteca.View;


public class CheckOut implements Operation {
    private final Library library;
    private final View view;

    public CheckOut(Library library, View view) {
        this.view = view;
        this.library = library;
    }

    @Override
    public void execute() {
        view.show("Enter the Name");
        String requestedItem = view.getInput();
        if (library.checkOut(requestedItem))
            view.show("Thank you! Enjoy");
        else
            view.show("That requested item is not available");
    }
}
