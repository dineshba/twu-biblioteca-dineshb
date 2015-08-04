package com.twu.biblioteca.operation;

import com.twu.biblioteca.Model.Library;
import com.twu.biblioteca.View;


public class ListCheckedOutItems implements Operation {
    private final Library library;
    private final View view;

    public ListCheckedOutItems(Library library, View view) {
        this.library = library;
        this.view = view;

    }

    @Override
    public void execute() {
        String details = library.checkedOutDetails();
        for (String detail : details.split("\n"))
            view.show(detail);
    }
}
