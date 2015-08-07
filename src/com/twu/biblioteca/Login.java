package com.twu.biblioteca;

import java.util.ArrayList;

public class Login {
    private final ArrayList<Users> users;
    private boolean logInStatus;

    public Login(ArrayList<Users> users) {
        this.users = users;
    }

    public Users authenticate(String name, String password, String roll) {
        for (Users user : users) {
            if (user.authenticate(name, password, roll)) {
                logInStatus = true;
                return user;
            }
        }
        return new Users("", "", "", "", "", "");
    }

    public Users execute(View view) {
        view.show("Enter the Role");
        String roll = view.getInput();
        view.show("Enter the Name");
        String name = view.getInput();
        view.show("Enter the Password");
        String password = view.getInput();
        return authenticate(name, password, roll);
    }

    public void resetStatus() {
        logInStatus = !logInStatus;
    }
}
