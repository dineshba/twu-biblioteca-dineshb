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

    @Override
    public boolean equals(Object that) {
        if (this == that)
            return true;
        if (that == null || getClass() != that.getClass())
            return false;

        Book another = (Book) that;
        if(bookName.equals(another.bookName))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        int result = bookName != null ? bookName.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (yearOfPublish != null ? yearOfPublish.hashCode() : 0);
        return result;
    }
}
