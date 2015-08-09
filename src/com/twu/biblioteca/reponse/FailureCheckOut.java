package com.twu.biblioteca.reponse;

public class FailureCheckOut implements Response {
    private final String failure = "Not available ";

    @Override
    public String toString() {
        return failure;
    }
}
