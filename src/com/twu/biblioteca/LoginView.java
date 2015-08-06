package com.twu.biblioteca;

public class LoginView implements IView{

    private final Login login;
    private final View view;
    private final NoUserView noUserView;
    private final UserView userView;
    private final LibraryView libraryView;
    private Users user;

    public LoginView(Login login, View view, LibraryView libraryView, UserView userView, NoUserView noUserView) {
        this.login = login;
        this.view = view;
        this.libraryView = libraryView;
        this.userView = userView;
        this.noUserView = noUserView;
    }

    @Override
    public IView execute() {
        this.user = login.execute(view);
        if (!user.isEmpty()) {
            if (user.isAdmin()) {
                return libraryView;
            }
            else {
                return userView;
            }
        }
        else
            return noUserView;
    }
}
