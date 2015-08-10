package com.twu.biblioteca.operation;

import com.twu.biblioteca.Users;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.View;
import com.twu.biblioteca.model.LibrarySection;

import java.util.HashMap;


public class  ListCheckedOutItems implements Operation {
    private final Library library;
    private final View view;
    private String representation;

    public ListCheckedOutItems(Library library, View view, String representation) {
        this.library = library;
        this.view = view;
        this.representation = representation;
    }

    @Override
    public void execute() {
        HashMap<LibrarySection, Users> details = library.checkedOutDetails();
        for (LibrarySection item : details.keySet()) {
            String header = item.header();
            printFormatter(header + " " + "User");
            break;
        }

        for (LibrarySection item : details.keySet()) {
            String itemDetails = item.toString();
            printFormatter(itemDetails + " " + details.get(item));
            break;
        }
    }

    private void printFormatter(String item) {
        String[] detail = item.split(" ");
        if (detail.length == 4)
            view.show(String.format("%-15s %-15s %-20s %-15s\n", detail[0], detail[1], detail[2], detail[3]));
        else
            view.show(String.format("%-15s %-15s %-15s %-15s %-15s\n", detail[0], detail[1], detail[2], detail[3], detail[4]));
    }

    @Override
    public String toString() {
        return "List Checked Out " + representation;
    }
}
