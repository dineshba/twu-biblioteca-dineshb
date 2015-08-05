package com.twu.biblioteca;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.operation.Operation;
import com.twu.biblioteca.operation.Parser;


public class Application {
    private final Login login;
    private View view;
    private Library library;
    private Parser parse;
    private Users user;
    private String menu;

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
                menu = "\n\n\nType the Options\n1.ListBooks\n2.CheckOutBook\n3.CheckInBook\n4.ListMovies\n5.CheckOutMovie\n6.CheckInMovie\n7.UserInformation\n8.ListCheckedOutBooks\n9.ListCheckOutMovies\n0.Quit\n\n\n";
                inputOutputLoop(runUntilQuit, user);
        }
            else
                menu = "\n\n\nType the Options\n1.ListBooks\n2.CheckOutBook\n3.CheckInBook\n4.ListMovies\n5.CheckOutMovie\n6.CheckInMovie\n7.UserInformation\n0.Quit\n\n\n";
                inputOutputLoop(runUntilQuit, user);
        }
    }

    private void inputOutputLoop(boolean runUntilQuit, Users user) {
        while (runUntilQuit) {
            view.show(menu);
            String option = view.getInput();
            if (option.length() == 1) {
                int userOption = Integer.parseInt(option);
                if(!user.isAdmin())
                    if(userOption == 8 || userOption == 9)
                        option = "Invalid";
            }
            Operation operation = parse.userInput(option, user);
            operation.execute();
        }
    }
}
