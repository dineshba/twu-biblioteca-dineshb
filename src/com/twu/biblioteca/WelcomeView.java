package com.twu.biblioteca;

public class WelcomeView implements IView{

    private final IView nextView;

    public WelcomeView(MainMenuView mainMenuView) {
        this.nextView = mainMenuView;
    }
    @Override
    public IView execute() {
        System.out.println("============Welcome=============");
        return nextView;
    }
}
