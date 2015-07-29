package com.twu.biblioteca;


public class CheckOut implements Operation {
    private final Library library;
    private final View view;

    public CheckOut(Library library, View view) {
        this.view = view;
        this.library = library;
    }

    @Override
    public void execute() {
        view.show("Enter the Book Name");
        String userBook =view.getInput();
        Boolean availability = library.checkBook(userBook);
        view.show(String.valueOf(availability));
    }
}
