package com.twu.biblioteca.view;


public class QuitView implements IView {

    @Override
    public IView execute() {
        System.exit(1);
        return null;
    }

    @Override
    public String toString() {
        return "Quit";
    }
}
