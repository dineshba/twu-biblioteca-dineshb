package com.twu.biblioteca;

import java.util.Scanner;


public class View implements IView{

    public void show(String message) {
        System.out.println(message);
    }

    public String getInput() {
        Scanner in = new Scanner(System.in);
        return in.next();
    }

    @Override
    public IView execute() {
        return null;
    }
}
