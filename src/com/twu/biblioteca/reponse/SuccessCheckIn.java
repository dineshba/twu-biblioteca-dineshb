package com.twu.biblioteca.reponse;

public class SuccessCheckIn implements Response{
    private final String success = "Thank you! for returning the ";

    @Override
    public String toString() {
        return success;
    }
}
