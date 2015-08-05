package com.twu.biblioteca.operation;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.Users;
import com.twu.biblioteca.View;


public class CheckOut implements Operation {
    private final Library library;
    private final View view;
    private final Users user;

    public CheckOut(Library library, View view, Users user) {
        this.view = view;
        this.library = library;
        this.user = user;
    }

    @Override
    public void execute() {
        view.show("Enter the Name");
        String requestedItem = view.getInput();
        if (library.checkOut(requestedItem, user))
            view.show("Thank you! Enjoy");
        else
            view.show("That requested item is not availableDetails");
    }
}
