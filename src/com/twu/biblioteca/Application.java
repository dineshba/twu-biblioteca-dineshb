package com.twu.biblioteca;


public class Application {

    private View view;
    private Library library;
    private Parser parse;
    private Operation operation;
    private Boolean run = true;

    public Application(View view, Library library, Parser parser) {
        this.view = view;
        this.library = library;
        this.parse = parser;
    }

    public void start() {
        view.show("=====================Welcome=====================");
        view.show("Enter the Options\n1.ListBooks\n2.Quit");
        while (run) {
            String option = view.getInput();
            operation = parse.userInput(library, view, option);
            run = operation.execute();
        }
    }
}
