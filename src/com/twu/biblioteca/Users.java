package com.twu.biblioteca;

public class Users {
    private final String roll;
    private final String name;
    private final String password;

    public Users(String name, String password, String roll) {
        this.name = name;
        this.password = password;
        this.roll = roll;
    }

    public boolean authenticate(String requestedName, String requestedPassword, String requestedRoll) {
        return false;
    }
}
