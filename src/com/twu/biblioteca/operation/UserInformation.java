package com.twu.biblioteca.operation;

import com.twu.biblioteca.Users;
import com.twu.biblioteca.View;

public class UserInformation implements Operation{

    private final Users user;
    private final View view;

    public UserInformation(View view,Users user) {
        this.user = user;
        this.view = view;
    }

    @Override
    public void execute() {
        view.show(String.format("%-15s %-15s %-15s", "Name", "Email", "Phone Number"));
        view.show(user.toString());
    }
}
