package com.twu.biblioteca.model;

import com.twu.biblioteca.Users;

import java.util.ArrayList;
import java.util.HashMap;


public class Library {
    private ArrayList<LibrarySection> available;
    private ArrayList<LibrarySection> checkedOut;
    private HashMap<LibrarySection, Users> checkedOutPerson;

    public Library(ArrayList<LibrarySection> available) {
        this.available = available;
        this.checkedOut = new ArrayList<LibrarySection>();
    }

    public ArrayList<LibrarySection> available() {
        return available;
    }

    public Boolean checkOut(String requestedItem, Users user) {
        for (LibrarySection item : available) {
            if (item.hasName(requestedItem)) {
                checkedOut.add(item);
                available.remove(item);
                checkedOutPerson.put(item, user);
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
