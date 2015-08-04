package com.twu.biblioteca;

import com.twu.biblioteca.Model.Library;
import com.twu.biblioteca.operation.Operation;
import com.twu.biblioteca.operation.Parser;


public class Application {
    private final Login login;
    private View view;
    private Library library;
    private Parser parse;
    private Users user;

    public Application(View view, Library library, Parser parser, Login login) {
        this.view = view;
        this.library = library;
        this.parse = parser;
        this.login = login;
    }

    public void start(boolean runUntilQuit) {
        view.show("=====================Welcome=====================");
        user = login.execute(view);
        if (!user.isEmpty()) {
            if (user.isAdmin()) {
                view.show("Type the Options\n1.ListItems\n2.CheckOutBook\n3.CheckInBook\n4.ListCheckedOutBooks\n5.ListMovies\n6.CheckOutMovie\n7.CheckInMovie\n8.ListCheckOutMovies\n0.Quit");
                inputOutputLoop(runUntilQuit, user);
        }
            else
                view.show("Type the Options\n1.ListItems\n2.CheckOutBook\n3.CheckInBook\n4.ListMovies\n5.CheckOutMovie\n6.CheckInMovie\n0.Quit");
                inputOutputLoop(runUntilQuit, user);
        }
    }

    private void inputOutputLoop(boolean runUntilQuit, Users user) {
        while (runUntilQuit) {
            String option = view.getInput();
            Operation operation = parse.userInput(option, user);
            operation.execute();
        }
    }
}
