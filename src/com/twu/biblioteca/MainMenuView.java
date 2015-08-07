package com.twu.biblioteca;

public class MainMenuView implements IView {

    private final View view;
    private final LoginView loginView;

    public MainMenuView(View view, LoginView loginView) {
        this.view = view;
        this.loginView = loginView;
    }
    @Override
    public IView execute() {
        view.show("\n\nEnter the Option\n1.Login\n0.Quit\n\n");
        String option = view.getInput();
        if (option.equals("0"))
            System.exit(0);
        if (option.equals("1"))
            return loginView;
        else
            return this;
    }
}
