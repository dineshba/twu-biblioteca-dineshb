package com.twu.biblioteca.operation;


public class Quit implements Operation {

    @Override
    public String execute() {
        System.exit(1);
        return null;
    }
}
