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
        ArrayList<HashMap> books = new ArrayList<HashMap>();
        HashMap book = new HashMap();
        book.put("bookName", "C++");
        book.put("Author", "Dinesh");
        book.put("Year of Published", "2010");
        books.add(book);
        Library library = new Library(books);
        View view = Mockito.mock(View.class);

        assertEquals(ListBooks.class, parser.userInput(library, view, "ListBooks").getClass());

    }

    @Test
    public void showSelectAValidOptionForInvalidOption() {
        Parser parser = new Parser();
        ArrayList<HashMap> books = new ArrayList<HashMap>();
        HashMap book = new HashMap();
        book.put("bookName", "C++");
        book.put("Author", "Dinesh");
        book.put("Year of Published", "2010");
        books.add(book);
        Library library = new Library(books);
        View view = Mockito.mock(View.class);

        assertEquals(InvalidOption.class, parser.userInput(library, view, "InvalidOption").getClass());
    }
}
