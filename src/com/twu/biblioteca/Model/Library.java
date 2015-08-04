package com.twu.biblioteca.Model;

import com.twu.biblioteca.Users;

import java.util.ArrayList;
import java.util.HashMap;


public class Library {
    private ArrayList<LibrarySection> available;
    private ArrayList<LibrarySection> checkedOut;
    private HashMap<LibrarySection, Users> checkedOutUser = new HashMap<LibrarySection, Users>();

    public Library(ArrayList<LibrarySection> available) {
        this.available = available;
        this.checkedOut = new ArrayList<LibrarySection>();
    }

    public Boolean checkOut(String requestedItem, Users user) {
        for (LibrarySection item : available) {
            if (item.hasName(requestedItem)) {
                checkedOut.add(item);
                available.remove(item);
                checkedOutUser.put(item, user);
                return true;
            }
        }
        return false;
    }

    public Boolean checkIn(String requestedItem, Users user) {
        for (LibrarySection item : checkedOut) {
            if (item.hasName(requestedItem)) {
                if (user.hasName(checkedOutUser.get(item))) {
                    available.add(item);
                    checkedOut.remove(item);
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
                formattedDetail += String.format("%-15s %-15s %-15s\n", detail[0], detail[1], detail[2]);
            else
                formattedDetail += String.format("%-15s %-15s %-15s %-15s\n", detail[0], detail[1], detail[2], detail[3]);
        }
        return formattedDetail;
    }

    public String checkedOutDetails() {
        String formattedDetail = "";
        for (LibrarySection item : checkedOut) {
            String itemDetail = item.toString();
            itemDetail += " " + checkedOutUser.get(item);
            String[] detail = itemDetail.split(" ");
            if (detail.length == 4)
                formattedDetail += String.format("%-15s %-15s %-15s %-15s\n", detail[0], detail[1], detail[2], detail[3]);
            else
                formattedDetail += String.format("%-15s %-15s %-15s %-15s %-15s\n", detail[0], detail[1], detail[2], detail[3], detail[4]);
        }
        return formattedDetail;
    }
}
