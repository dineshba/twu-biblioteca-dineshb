package com.twu.biblioteca;

public class WelcomeView implements IView{

    private final IView nextView;

    public WelcomeView(IView loginView) {
        this.nextView = loginView;
    }
    @Override
    public IView execute() {
        System.out.println("============Welcome=============");
        return nextView;
    }
}
