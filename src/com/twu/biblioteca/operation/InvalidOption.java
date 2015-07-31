package com.twu.biblioteca.operation;


public class InvalidOption implements Operation {

    @Override
    public String execute() {
        return "Select a valid option!";
    }
}
