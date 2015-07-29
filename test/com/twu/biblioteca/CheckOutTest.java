package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;


public class CheckOutTest {

    @Test
    public void displayAvailabilityMessageByView() {
        HashMap bookOne = buildBookOne();
        HashMap bookTwo = buildBookTwo();
        Library library = buildLibrary(bookOne, bookTwo);
        View view = Mockito.mock(View.class);
        CheckOut checkOut = new CheckOut(library, view);

        Mockito.when(view.getInput()).thenReturn("C++");
        checkOut.execute();

        Mockito.verify(view).show("Thank you! Enjoy the book");
    }

    @Test
    public void displayNotAvailableAsBookInCheckedOutList() {
        HashMap bookOne = buildBookOne();
        HashMap bookTwo = buildBookTwo();
        Library library = buildLibrary(bookOne, bookTwo);
        View view = Mockito.mock(View.class);
        CheckOut checkOut = new CheckOut(library, view);

        Mockito.when(view.getInput()).thenReturn("C");
        checkOut.execute();

        Mockito.verify(view).show("That Book is not available");
    }

    private Library buildLibrary(HashMap bookOne, HashMap bookTwo) {
        ArrayList<HashMap> books = new ArrayList<HashMap>();
        books.add(bookOne);
        books.add(bookTwo);
        return new Library(books);
    }

    private HashMap buildBookTwo() {
        return buildBook("C++", "Dinesh", "2010");
    }

    private HashMap buildBook(String name, String author, String yearOfPublishing) {
        HashMap book = new HashMap();
        book.put("bookName", name);
        book.put("Author", author);
        book.put("Year of Published", yearOfPublishing);
        return book;
    }

    private HashMap buildBookOne() {
        return buildBook("Java", "Robert", "2009");
    }
}
