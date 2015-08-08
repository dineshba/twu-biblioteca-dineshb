package com.twu.biblioteca.operation;

import com.twu.biblioteca.Login;

public class Logout implements  Operation {

    private final Login login;

    public Logout(Login login) {
        this.login = login;
    }
    @Override
    public void execute() {
        login.resetLoginStatus();
    }

    @Override
    public String toString() {
        return "Logout";
    }
}
