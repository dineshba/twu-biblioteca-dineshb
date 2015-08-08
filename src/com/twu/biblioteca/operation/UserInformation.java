package com.twu.biblioteca.operation;

import com.twu.biblioteca.Login;
import com.twu.biblioteca.Users;
import com.twu.biblioteca.View;

public class UserInformation implements Operation{

    private final View view;
    private final Login login;

    public UserInformation(View view, Login login) {
        this.view = view;
        this.login = login;
    }

    @Override
    public void execute() {
        view.show(String.format("%-15s %-15s %-15s %-15s", "Number", "Name", "Email", "Phone Number"));
        Users user = login.getCurrentUser();
        view.show(user.toString());
    }

    @Override
    public String toString() {
        return "UserInformation";
    }
}
