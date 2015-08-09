package com.twu.biblioteca.operation;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.View;


public class  ListCheckedOutItems implements Operation {
    private final Library library;
    private final View view;
    private String representation;

    public ListCheckedOutItems(Library library, View view, String representation) {
        this.library = library;
        this.view = view;
        this.representation = representation;
    }

    @Override
    public void execute() {
        String details = library.checkedOutDetails();
        for (String detail : details.split("\n"))
            view.show(detail);
    }

    @Override
    public String toString() {
        return "List Checked Out " + representation;
    }
}
