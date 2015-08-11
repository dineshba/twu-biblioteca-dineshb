package com.twu.biblioteca.reponse;

public class FailureCheckIn implements Response {
    private final String failure = "This is not a valid ";

    @Override
    public String toString() {
        return failure;
    }
}
