package com.twu.biblioteca.operation;


import com.twu.biblioteca.View;

public class InvalidOption implements Operation {
    private final View view;

    public InvalidOption(View view) {
        this.view = view;
    }

    @Override
    public void execute() {
        view.show("Select a valid option!");
    }
}
