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

    public void start(boolean runUntilQuit) {
        view.show("=====================Welcome=====================");
        view.show("Type the Options\n1.ListBooks\n2.CheckOut\n3.CheckIn\n4.Quit");
        inputOutputLoop(runUntilQuit);
    }

    private void inputOutputLoop(boolean runUntilQuit) {
        while (runUntilQuit) {
            String option = view.getInput();
            Operation operation = parse.userInput(option);
            operation.execute();
        }
    }
}
