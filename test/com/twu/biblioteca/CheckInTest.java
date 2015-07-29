package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;

public class CheckInTest {

    @Test
    public void shouldNotAllowToCheckInWhenCheckOutListIsEmpty() {
        ArrayList<HashMap> books = buildBook();
        Library library = new Library(books);
        View view = Mockito.mock(View.class);
        CheckIn checkIn = new CheckIn(library, view);
        Mockito.when(view.getInput()).thenReturn("Java");

        checkIn.execute();

        Mockito.verify(view).show("That is not a valid book to return");
    }

    private ArrayList<HashMap> buildBook() {
        HashMap bookOne = new HashMap();
        HashMap bookTwo = new HashMap();
        bookOne.put("bookName", "Java");
        bookOne.put("Author", "Robert");
        bookOne.put("Year of Published", "2009");
        bookTwo.put("bookName", "C++");
        bookTwo.put("Author", "Dinesh");
        bookTwo.put("Year of Published", "2010");
        ArrayList<HashMap> books = new ArrayList<HashMap>();
        books.add(bookOne);
        books.add(bookTwo);
        return books;
    }
}