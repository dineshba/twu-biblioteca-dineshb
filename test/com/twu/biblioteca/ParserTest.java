package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;


public class ParserTest {

    @Test
    public void showTheBooksWhenUserInputIsListBook() {
        Parser parser = new Parser();
        HashMap bookOne = buildBookOne();
        HashMap bookTwo = buildBookTwo();
        ArrayList<HashMap> books = buildLibrary(bookOne, bookTwo);
        Library library = new Library(books);
        View view = new View();

        assertEquals(ListBooks.class, parser.userInput(library, view, "ListBooks").getClass());

    }

    @Test
    public void showSelectAValidOptionForInvalidOption() {
        Parser parser = new Parser();
        HashMap bookOne = buildBookOne();
        HashMap bookTwo = buildBookTwo();
        ArrayList<HashMap> books = buildLibrary(bookOne, bookTwo);
        Library library = new Library(books);
        View view = new View();

        assertEquals(InvalidOption.class, parser.userInput(library, view, "InvalidOption").getClass());
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
