package com.twu.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;


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

        parser.userInput(library, view, "List Books");

        Mockito.verify(view).showBook(book);
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

        parser.userInput(library, view, "List");

        Mockito.verify(view).show("Select a valid option!");
    }
}
