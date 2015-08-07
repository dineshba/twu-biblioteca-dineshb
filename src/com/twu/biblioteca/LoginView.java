package com.twu.biblioteca;

public class LoginView implements IView{

    private final Login login;
    private final View view;
    private final UserView userView;
    private final LibraryView libraryView;

    public LoginView(Login login, View view, LibraryView libraryView, UserView userView) {
        this.login = login;
        this.view = view;
        this.libraryView = libraryView;
        this.userView = userView;
    }

    @Override
    public IView execute() {
        Users user = login.execute(view);
            if (!user.isEmpty()) {
            if (user.isAdmin()) {
                return libraryView;
            }
            else {
                return userView;
            }
        }
        view.show("Invalid Login");
        return null;
    }
}
