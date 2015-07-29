package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;


public class ListBooksTest {

    @Test
    public void libraryShouldGiveBookToView() {
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
        Library library = new Library(books);
        View view = Mockito.mock(View.class);
        ListBooks listBooks = new ListBooks(library, view);

        listBooks.execute();
        Mockito.verify(view).showBook(bookOne);
        Mockito.verify(view).showBook(bookTwo);
    }
}