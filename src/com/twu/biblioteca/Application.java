package com.twu.biblioteca;


public class Application {

    private View view;
    private Library library;
    private Parser parse;
    private Operation operation;

    public Application(View view, Library library, Parser parser) {
        this.view = view;
        this.library = library;
        this.parse = parser;
    }

    public void start(boolean runUntilQuit) {
        view.show("=====================Welcome=====================");
        view.show("Enter the Options\n1.ListBooks\n2.CheckOut\n3.Quit");
        inputOutputLoop(runUntilQuit);
    }

    private void inputOutputLoop(boolean runUntilQuit) {
        while (runUntilQuit) {
            String option = view.getInput();
            operation = parse.userInput(library, view, option);
            operation.execute();
        }
    }
}
