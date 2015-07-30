package com.twu.biblioteca;

import java.util.Scanner;


public class View {

    public void show(String message) {
        System.out.println(message);
    }

    public String getInput() {
        Scanner in = new Scanner(System.in);
        return in.next();
    }
}
