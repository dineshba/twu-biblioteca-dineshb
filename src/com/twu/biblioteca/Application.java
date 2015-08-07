package com.twu.biblioteca;


public class Application {

    private MainMenuView mainMenuView;
    private IView iView;

    public Application(WelcomeView welcomeView, MainMenuView mainMenuView) {
        this.iView = welcomeView;
        this.mainMenuView = mainMenuView;
    }

    public void start() {
        while (true) {
            try {
                iView = iView.execute();
            }
            catch (NullPointerException e) {
                iView = mainMenuView;
            }
        }
    }
}
