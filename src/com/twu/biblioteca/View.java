package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Scanner;


public class View {

    public void show(String message) {
        System.out.println(message);
    }

    public void showBook(HashMap book) {
        System.out.println(String.format("%-15s %-15s %-10s", book.get("bookName"), book.get("Author"), book.get("Year of Published")));
    }

    public String getInput() {
        Scanner in = new Scanner(System.in);
        return in.next();
    }
}
