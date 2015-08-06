package com.twu.biblioteca;

import com.twu.biblioteca.operation.Operation;
import com.twu.biblioteca.operation.Parser;


public class Application {
    private final Login login;
    private final View view;
    private final Parser parse;
    private Users user;
    private String menu;

    public Application(View view, Parser parser, Login login) {
        this.view = view;
        this.parse = parser;
        this.login = login;
    }

    public void start(boolean runUntilQuit) {
        view.show("=====================Welcome=====================");
        while (runUntilQuit) {
            view.show("\n\nEnter the Options\n1.Login\n0.Quit");
            String option = view.getInput();
            if (option.equals("0")) {
                break;
            }
            else if (option.equals("1")) {
                user = login.execute(view);
                assignMenuToUserAndRun();
            }
            else
                view.show("Invalid option");
        }
    }

    private void assignMenuToUserAndRun() {
        if (!user.isEmpty()) {
            if (user.isAdmin()) {
                menu = "\n\n\nEnter the Options\n1.ListBooks\n2.CheckOutBook\n3.CheckInBook\n4.ListMovies\n5.CheckOutMovie\n6.CheckInMovie\n7.UserInformation\n8.ListCheckedOutBooks\n9.ListCheckOutMovies\n0.Logout\n\n\n";
                inputOutputLoop(user);
            }
            else {
                menu = "\n\n\nEnter the Options\n1.ListBooks\n2.CheckOutBook\n3.CheckInBook\n4.ListMovies\n5.CheckOutMovie\n6.CheckInMovie\n7.UserInformation\n0.Logout\n\n\n";
                inputOutputLoop(user);
            }
        }
        else
            view.show("Mismatch between User and Password");
    }

    private void inputOutputLoop(Users user) {
        while (true) {
            view.show(menu);
            String option = view.getInput();
            if (option.length() == 1) {
                int userOption = Integer.parseInt(option);
                if(!user.isAdmin())
                    if(userOption == 8 || userOption == 9)
                        option = "Invalid";
            }
            if(option.equals("0"))
                break;
            Operation operation = parse.userInput(option);
            operation.execute();
        }
    }
}
