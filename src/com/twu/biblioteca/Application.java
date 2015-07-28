package com.twu.biblioteca;

public class Application {

    private View view;
    private Library library;

    public Application(View view, Library library) {
        this.view = view;
        this.library = library;
    }

    public void start() {
        view.show("=====================Welcome=====================");
        view.show(String.format("%-15s %-15s %-10s", "BookName", "Author", "Year of Published"));
        library.giveBookTo(view);
    }

}
