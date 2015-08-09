package com.twu.biblioteca.reponse;

public class SuccessCheckOut implements Response {
    private final String success = "Thank you! Enjoy the ";

    @Override
    public String toString() {
        return success;
    }
}
