package com.twu.biblioteca.operation;


public class Quit implements Operation {

    @Override
    public void execute() {
        System.exit(1);
    }
}
