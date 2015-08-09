package com.twu.biblioteca.reponse;

public class Success implements Response {
    private final String success = "Thank you! Enjoy the ";

    @Override
    public String toString() {
        return success;
    }
}
