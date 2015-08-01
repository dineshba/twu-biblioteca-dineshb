package com.twu.biblioteca;

public class Book {

    private final String bookName;
    private final String author;
    private final String yearOfPublish;

    public Book(String bookName, String author, String yearOfPublish) {
        this.bookName = bookName;
        this.author = author;
        this.yearOfPublish = yearOfPublish;
    }

    public boolean hasName(String requestedBookName) {
        return bookName.equals(requestedBookName);
    }

    @Override
    public String toString() {
        return bookName + " " + author + " " + yearOfPublish;
    }
}
