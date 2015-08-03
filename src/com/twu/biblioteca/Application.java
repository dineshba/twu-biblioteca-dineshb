package com.twu.biblioteca;

import com.twu.biblioteca.Model.Library;
import com.twu.biblioteca.operation.Operation;
import com.twu.biblioteca.operation.Parser;


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
        view.show("Type the Options\n1.ListItems\n2.CheckOutBook\n3.CheckInBook\n4.ListCheckedOutBooks\n5.ListMovies\n6.CheckOutMovie\n0.Quit");
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
