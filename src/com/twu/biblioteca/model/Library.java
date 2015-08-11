package com.twu.biblioteca.model;

import com.twu.biblioteca.helper.Login;
import com.twu.biblioteca.reponse.*;

import java.util.ArrayList;
import java.util.HashMap;


public class Library {
    private final Login login;
    private final FailureCheckIn failureCheckIn;
    private final FailureCheckOut failureCheckOut;
    private final SuccessCheckIn successCheckIn;
    private ArrayList<LibrarySection> available;
    private HashMap<LibrarySection, Users> checkedOutUser = new HashMap<LibrarySection, Users>();
    private Users user;
    private final SuccessCheckOut successCheckOut;

    public Library(ArrayList<LibrarySection> available, Login login, SuccessCheckOut successCheckOut, FailureCheckOut failureCheckOut, SuccessCheckIn successCheckIn, FailureCheckIn failureCheckIn) {
        this.login = login;
        this.available = available;
        this.successCheckOut = successCheckOut;
        this.failureCheckOut = failureCheckOut;
        this.successCheckIn = successCheckIn;
        this.failureCheckIn = failureCheckIn;
    }

    private void getCurrentUser() {
        this.user = login.getCurrentUser();
    }

    public Response checkOut(String requestedItem) {
        getCurrentUser();
        for (LibrarySection item : available) {
            if (item.hasName(requestedItem)) {
                available.remove(item);
                checkedOutUser.put(item, user);
                return successCheckOut;
            }
        }
        return failureCheckOut;
    }

    public Response checkIn(String requestedItem) {
        getCurrentUser();
        for (LibrarySection item : checkedOutUser.keySet()) {
            if (item.hasName(requestedItem)) {
                if (user.hasName(checkedOutUser.get(item))) {
                    available.add(item);
                    checkedOutUser.remove(item);
                    return successCheckIn;
                }
            }
        }
        return failureCheckIn;
    }

    public ArrayList<LibrarySection> availableDetails() {
        return available;
    }

    public HashMap<LibrarySection, Users> checkedOutDetails() {
        return checkedOutUser;
    }
}
