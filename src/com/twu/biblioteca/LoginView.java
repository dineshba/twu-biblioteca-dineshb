package com.twu.biblioteca;

public class LoginView implements IView {

    private final Login login;
    private final View view;
    private final CustomerView customerView;
    private final LibrarianView librarianView;

    public LoginView(Login login, View view, LibrarianView librarianView, CustomerView customerView) {
        this.login = login;
        this.view = view;
        this.librarianView = librarianView;
        this.customerView = customerView;
    }

    @Override
    public IView execute() {
        Users user = login.execute(view);
        if (login.status()) {
            if (user.isAdmin()) {
                return librarianView;
            }
            else {
                return customerView;
            }
        }
        view.show("Invalid Login");
        return null;
    }

    @Override
    public String toString() {
        return "Login";
    }
}
