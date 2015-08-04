package com.twu.biblioteca.operation;

import com.twu.biblioteca.Model.Library;
import com.twu.biblioteca.Model.LibrarySection;
import com.twu.biblioteca.View;

import java.util.ArrayList;


public class ListItems implements Operation {
    private final Library library;
    private final View view;

    public ListItems(Library library, View view) {
        this.library = library;
        this.view = view;

    }

    @Override
    public void execute() {
        String items = library.availableDetails();
        for (String item : items.split("\n")) {
            view.show(item);
        }
    }
}
