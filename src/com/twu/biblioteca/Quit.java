package com.twu.biblioteca;


public class Quit implements Operation {

    @Override
    public void execute() {
        System.exit(1);
    }
}
