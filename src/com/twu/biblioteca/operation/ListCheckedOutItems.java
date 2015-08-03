package com.twu.biblioteca.operation;

import com.twu.biblioteca.Model.Library;
import com.twu.biblioteca.Model.LibrarySection;
import com.twu.biblioteca.View;

import java.util.ArrayList;


public class ListCheckedOutItems implements Operation{
    private final Library library;
    private final View view;

    public ListCheckedOutItems(Library library, View view) {
        this.library = library;
        this.view = view;

    }

    @Override
    public void execute() {
        view.show(String.format("%-15s %-15s %-10s", "BookName", "Author", "Year of Published"));
        ArrayList<LibrarySection> items = library.checkedOut();
        for (LibrarySection item : items) {
            String bookDetail = item.toString();
            String[] detail = bookDetail.split(" ");
            String formattedBookDetail = String.format("%-15s %-15s %-10s", detail[0], detail[1], detail[2]);
            view.show(formattedBookDetail);
        }
    }
}
