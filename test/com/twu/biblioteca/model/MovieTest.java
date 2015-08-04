package com.twu.biblioteca.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MovieTest {

    @Test
    public void MoviesAreSameWhenTheirNamesAreName() {
        Movie movie = new Movie("Sivaji", "2009", "Sankar", "10");

        assertTrue(movie.hasName("Sivaji"));
    }

    @Test
    public void getDetailsOfMovie() {
        Movie movie = new Movie("Sivaji", "2009", "Sankar", "10");

        assertEquals("Sivaji 2009 Sankar 10", movie.toString());
    }
}
