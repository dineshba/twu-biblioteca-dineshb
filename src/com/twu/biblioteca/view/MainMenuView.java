package com.twu.biblioteca.view;

import com.twu.biblioteca.helper.Executer;

import java.util.HashMap;


public class MainMenuView implements IView {

    private final View view;
    private final HashMap<String, IView> commands;
    private final Executer executer;

    public MainMenuView(View view, HashMap<String, IView> commands, Executer executer) {
        this.view = view;
        this.commands = commands;
        this.executer = executer;
    }

    @Override
    public IView execute() {
        view.show(this + "");
        return executer.executeMainMenu(view, commands);
    }

    @Override
    public String toString() {
        String input = "";
        int index = 0;
        String stringIndex = "" + index;
        while (commands.containsKey(stringIndex)) {
            input += stringIndex + " " + commands.get(stringIndex) + '\n';
            stringIndex = "" + ++index;
        }
        return input;
    }
}
