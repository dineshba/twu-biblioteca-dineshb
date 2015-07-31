package com.twu.biblioteca.operation;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Library;

import java.util.ArrayList;


public class ListBooks implements Operation {
    private final Library library;

    public ListBooks(Library library) {
        this.library = library;

    }

    @Override
    public String execute() {
        ArrayList<Book> books = library.availableBooks();
        String finalFormattedBookDetail = String.format("%-15s %-15s %-10s", "BookName", "Author", "Year of Published");
        for (Book book : books) {
            String bookDetail = book.getDetail();
            String[] detail = bookDetail.split(" ");
            String formattedBookDetail = String.format("\n%-15s %-15s %-10s", detail[0], detail[1], detail[2]);
            finalFormattedBookDetail += formattedBookDetail ;
        }
        return finalFormattedBookDetail;
        }
    }
