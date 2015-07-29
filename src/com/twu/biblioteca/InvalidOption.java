package com.twu.biblioteca;


public class InvalidOption implements Operation {
    private final View view;

    InvalidOption(View view) {
        this.view = view;
    }
    @Override
    public Boolean execute() {
        view.show("Select a valid option!");
        return true;
    }
}
