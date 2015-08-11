package com.twu.biblioteca.helper;

import com.twu.biblioteca.view.IView;
import com.twu.biblioteca.view.MainMenuView;
import com.twu.biblioteca.view.WelcomeView;


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
