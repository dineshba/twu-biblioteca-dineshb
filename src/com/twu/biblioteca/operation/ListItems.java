package com.twu.biblioteca.operation;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.LibrarySection;
import com.twu.biblioteca.view.View;
import java.util.ArrayList;


public class ListItems implements Operation {
    private final Library library;
    private final View view;
    private final String representation;

    public ListItems(Library library, View view, String representation) {
        this.library = library;
        this.view = view;
        this.representation = representation;
    }

    @Override
    public void execute() {
        ArrayList<LibrarySection> items = library.availableDetails();
        for (LibrarySection item : items) {
            String header = item.header();
            printFormatter(header);
            break;
        }
        for (LibrarySection item : items) {
            String itemDetail = item.toString();
            printFormatter(itemDetail);
        }
    }

    @Override
    public String toString() {
        return "List " + representation;
    }

    private void printFormatter(String item) {
        String[] detail = item.split(" ");
        if (detail.length == 3)
            view.show(String.format("%-15s %-15s %-20s\n", detail[0], detail[1], detail[2]));
        else
            view.show(String.format("%-15s %-15s %-15s %-15s\n", detail[0], detail[1], detail[2], detail[3]));
    }
}
