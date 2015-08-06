package com.twu.biblioteca;

import com.twu.biblioteca.operation.Operation;
import com.twu.biblioteca.operation.Parser;

public class LibraryView implements IView {

    private final Parser parser;
    private View view;

    public LibraryView(View view, Parser parser) {
        this.view = view;
        this.parser = parser;
    }

    @Override
    public IView execute() {
        view.show("\n\n\nEnter the Options\n1.ListBooks\n2.CheckOutBook\n3.CheckInBook\n4.ListMovies\n5.CheckOutMovie\n6.CheckInMovie\n7.UserInformation\n8.ListCheckedOutBooks\n9.ListCheckOutMovies\n0.Logout\n\n\n");
        String input = view.getInput();
        Operation operation = parser.userInput(input);
        operation.execute();
        return null;
    }
}
