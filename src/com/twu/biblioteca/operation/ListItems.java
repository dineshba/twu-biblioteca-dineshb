package com.twu.biblioteca.operation;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.View;


public class ListItems implements Operation {
    private final Library library;
    private final View view;
    private final String representation;

    public ListItems(Library library, View view, String representation) {
        this.library = library;
        this.view = view;
        this.representation = representation;
    }

    @Override
    public void execute() {
        String items = library.availableDetails();
        for (String item : items.split("\n")) {
            view.show(item);
        }
    }

    @Override
    public String toString() {
        return "List " + representation;
    }
}
