package com.twu.biblioteca;

import java.util.Scanner;

public class Application {

    private View view;
    private Library library;
    private Parser parse;

    public Application(View view, Library library, Parser parser) {
        this.view = view;
        this.library = library;
        this.parse = parser;
    }

    public void start() {
        view.show("=====================Welcome=====================");
        String option = view.getInput();
        parse.userInput(library, view, option);
            view.show(String.format("%-15s %-15s %-10s", "BookName", "Author", "Year of Published"));
            library.giveBookTo(view);

    }
}
