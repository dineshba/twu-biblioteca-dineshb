package com.twu.biblioteca.model;

import com.twu.biblioteca.Login;
import com.twu.biblioteca.Users;

import java.util.ArrayList;
import java.util.HashMap;


public class Library {
    private final Login login;
    private ArrayList<LibrarySection> available;
    private HashMap<LibrarySection, Users> checkedOutUser = new HashMap<LibrarySection, Users>();
    private Users user;

    public Library(ArrayList<LibrarySection> available, Login login) {
        this.login = login;
        this.available = available;
    }

    private void getCurrentUser() {
        this.user = login.getCurrentUser();
    }

    public Boolean checkOut(String requestedItem) {
        getCurrentUser();
        for (LibrarySection item : available) {
            if (item.hasName(requestedItem)) {
                available.remove(item);
                checkedOutUser.put(item, user);
                return true;
            }
        }
        return false;
    }

    public Boolean checkIn(String requestedItem) {
        getCurrentUser();
        for (LibrarySection item : checkedOutUser.keySet()) {
            if (item.hasName(requestedItem)) {
                if (user.hasName(checkedOutUser.get(item))) {
                    available.add(item);
                    checkedOutUser.remove(item);
                    return true;
                }
            }
        }
        return false;
    }

    public String availableDetails() {
        String formattedDetail = "";
        for (LibrarySection item : available) {
            String itemDetail = item.toString();
            String[] detail = itemDetail.split(" ");
            if (detail.length == 3)
                formattedDetail += String.format("%-15s %-15s %-20s\n", detail[0], detail[1], detail[2]);
            else
                formattedDetail += String.format("%-15s %-15s %-15s %-15s\n", detail[0], detail[1], detail[2], detail[3]);
        }
        return formattedDetail;
    }

    public String checkedOutDetails() {
        String formattedDetail = "";
        for (LibrarySection item : checkedOutUser.keySet()) {
            String itemDetail = item.toString();
            itemDetail += " " + checkedOutUser.get(item);
            String[] detail = itemDetail.split(" ");
            if (detail.length == 4)
                formattedDetail += String.format("%-15s %-15s %-20s %-15s\n", detail[0], detail[1], detail[2], detail[3]);
            else
                formattedDetail += String.format("%-15s %-15s %-15s %-15s %-15s\n", detail[0], detail[1], detail[2], detail[3], detail[4]);
        }
        return formattedDetail;
    }
}
