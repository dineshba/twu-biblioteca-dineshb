package com.twu.biblioteca.operation;


import com.twu.biblioteca.Operation;

public class Quit implements Operation {

    @Override
    public void execute() {
        System.exit(1);
    }
}
