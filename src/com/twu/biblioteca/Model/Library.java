package com.twu.biblioteca.Model;

import java.util.ArrayList;


public class Library {
    private ArrayList<LibrarySection> available;
    private ArrayList<LibrarySection> checkedOut;

    public Library(ArrayList<LibrarySection> available) {
        this.available = available;
        this.checkedOut = new ArrayList<LibrarySection>();
    }

    public ArrayList<LibrarySection> available() {
        return available;
    }

    public Boolean checkOut(String requestedItem) {
        for (LibrarySection item : available) {
            if (item.hasName(requestedItem)) {
                checkedOut.add(item);
                available.remove(item);
                return true;
            }
        }
        return false;
    }

    public Boolean checkIn(String requestedItem) {
        for (LibrarySection item : checkedOut) {
            if (item.hasName(requestedItem)) {
                available.add(item);
                checkedOut.remove(item);
                return true;
            }
        }
        return false;
    }

    public ArrayList<LibrarySection> checkedOut() {
        return checkedOut;
    }
}
