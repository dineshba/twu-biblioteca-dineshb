package com.twu.biblioteca.operation;

import com.twu.biblioteca.Model.Library;
import com.twu.biblioteca.Users;
import com.twu.biblioteca.View;


public class Parser {
    private final Library bookLibrary;
    private final View view;
    private final Library movieLibrary;

    public Parser(Library bookLibrary, Library movieLibrary, View view) {
        this.bookLibrary = bookLibrary;
        this.movieLibrary = movieLibrary;
        this.view = view;
    }

    public Operation userInput(String input, Users user) {
        if (input.equals("0"))
            return new Quit();
        else if (input.equals("1")) {
            view.show(String.format("%-15s %-15s %-10s", "BookName", "Author", "Year of Published"));
            return new ListItems(bookLibrary, view);
        }
        else if (input.equals("2")) {
            return new CheckOut(bookLibrary, view, user);
        }
        else if (input.equals("3")) {
            return new CheckIn(bookLibrary, view);
        }
        else if (input.equals("4")) {
            return new ListCheckedOutItems(bookLibrary, view);
        }
        else if (input.equals("5")) {
            view.show(String.format("%-15s %-15s %-10s %-10s", "MovieName", "Year", "Director", "Rating"));
            return new ListItems(movieLibrary, view);
        }
        else if (input.equals("6")) {
            return new CheckOut(movieLibrary, view, user);
        }
        else if (input.equals("7")) {
            return new CheckIn(movieLibrary, view);
        }
        else if(input.equals("8")) {
            view.show(String.format("%-15s %-15s %-10s %-10s", "MovieName", "Year", "Director", "Rating"));
            return new ListCheckedOutItems(movieLibrary, view);
        }
        else
            return new InvalidOption(view);
    }
}
