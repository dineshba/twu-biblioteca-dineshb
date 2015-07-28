package com.twu.biblioteca;


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
    }
}
