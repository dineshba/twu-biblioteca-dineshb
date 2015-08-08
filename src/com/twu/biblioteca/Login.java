package com.twu.biblioteca;

import java.util.ArrayList;

public class Login {
    private final ArrayList<Users> users;
    private Users user;
    private boolean status;

    public Login(ArrayList<Users> users) {
        this.users = users;
    }

    public Users authenticate(String name, String password, String roll) {
        for (Users user : users) {
            if (user.authenticate(name, password, roll)) {
                status = true;
                this.user = user;
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

    public Users getCurrentUser() {
        return user;
    }

    public void resetLoginStatus() {
        status = !status;
    }

    public boolean getCurrentStatus() {
        return status;
    }
}
