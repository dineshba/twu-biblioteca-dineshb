package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MovieTest {

    @Test
    public void MoviesAreSameWhenTheirNamesAreName() {
        Movie movie = new Movie("Sivaji", "2009", "Sankar", "10");

        assertTrue(movie.hasName("Sivaji"));
    }
}
