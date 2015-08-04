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
}
