package com.twu.biblioteca;

public class Application {

    private View view;
    private Library library;

    public Application(View view, Library library) {
        this.view = view;
        this.library = library;
    }

    public void start() {
        view.welcomeMessage();
        library.giveBookTo(view);
    }

}
