package com.twu.biblioteca;


public class ListBooks implements Operation {

    private final Library library;
    private final View view;

    public ListBooks(Library library, View view) {
        this.library = library;
        this.view = view;

    }
    @Override
    public void execute() {
        view.show(String.format("%-15s %-15s %-10s", "BookName", "Author", "Year of Published"));
        library.giveBookTo(view);
    }
}
