package com.twu.biblioteca;


public class Movie {
    private final String name;
    private final String year;
    private final String director;
    private final String rating;

    public Movie(String name, String year, String director, String rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public boolean hasName(String requestedMovie) {
        return name.equals(requestedMovie);
    }

    @Override
    public String toString() {
        return name + " " + year + " " + director + " " + rating;
    }
}