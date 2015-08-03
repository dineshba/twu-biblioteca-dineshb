package com.twu.biblioteca.Model;


public class Book implements LibrarySection{

    private final String bookName;
    private final String author;
    private final String yearOfPublish;

    public Book(String bookName, String author, String yearOfPublish) {
        this.bookName = bookName;
        this.author = author;
        this.yearOfPublish = yearOfPublish;
    }

    @Override
    public boolean hasName(String requestedItem) {
        return bookName.equals(requestedItem);
    }

    @Override
    public String toString() {
        return bookName + " " + author + " " + yearOfPublish;
    }
}
