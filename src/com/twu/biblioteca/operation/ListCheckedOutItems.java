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
        ArrayList<LibrarySection> items = library.checkedOut();
        for (LibrarySection item : items) {
            String itemDetail = item.toString();
            String[] detail = itemDetail.split(" ");
            String formattedDetail = "";
            if(detail.length == 3)
                formattedDetail = String.format("%-15s %-15s %-10s", detail[0], detail[1], detail[2]);
            else
                formattedDetail = String.format("%-15s %-15s %-10s %-10s", detail[0], detail[1], detail[2], detail[3]);
            view.show(formattedDetail);
        }
    }
}
