package com.twu.biblioteca.operation;

import com.twu.biblioteca.view.View;
import com.twu.biblioteca.model.Library;


public class CheckOut implements Operation {
    private final Library library;
    private final View view;
    private String representation;

    public CheckOut(Library library, View view, String representation) {
        this.view = view;
        this.library = library;
        this.representation = representation;
    }

    @Override
    public void execute() {
        view.show("Enter the Name");
        String requestedItem = view.getInput();
        view.show(library.checkOut(requestedItem) + "" + representation);
    }

    @Override
    public String toString() {
        return "CheckOut " + representation;
    }
}
