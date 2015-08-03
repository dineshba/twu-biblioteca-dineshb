package com.twu.biblioteca.Model;


import com.twu.biblioteca.Model.LibrarySection;

public class Movie implements LibrarySection {
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

    @Override
    public boolean hasName(String requestedItem) {
        return name.equals(requestedItem);
    }

    @Override
    public String toString() {
        return name + " " + year + " " + director + " " + rating;
    }
}
