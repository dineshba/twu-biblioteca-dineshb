package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;


public class ListBooksTest {

    @Test
    public void libraryShouldGiveBookToView() {
        HashMap bookOne = buildBookOne();
        HashMap bookTwo = buildBookTwo();
        ArrayList<HashMap> books = buildLibrary(bookOne, bookTwo);
        Library library = new Library(books);
        View view = Mockito.mock(View.class);
        ListBooks listBooks = new ListBooks(library, view);

        listBooks.execute();
        Mockito.verify(view).showBooks(library);
    }

    private ArrayList<HashMap> buildLibrary(HashMap bookOne, HashMap bookTwo) {
        ArrayList<HashMap> books = new ArrayList<HashMap>();
        books.add(bookOne);
        books.add(bookTwo);
        return books;
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