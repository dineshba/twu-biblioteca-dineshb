package com.twu.biblioteca;

import java.util.ArrayList;

public class Login {
    private final ArrayList<Users> users;

    public Login(ArrayList<Users> users) {
        this.users = users;
    }

    public boolean authenticate(String name, String password, String roll) {
        for (Users user : users) {
            if (user.authenticate(name, password, roll))
                return true;
        }
        return false;
    }

    public boolean execute(View view) {
        view.show("Enter the Roll");
        String roll = view.getInput();
        view.show("Enter the Name");
        String name = view.getInput();
        view.show("Enter the Password");
        String password = view.getInput();
        return authenticate(name, password, roll);
    }
}
