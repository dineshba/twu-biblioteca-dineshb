package com.twu.biblioteca;

import com.twu.biblioteca.operation.Operation;

import java.util.HashMap;


public class CustomerView implements IView{

    private final View view;
    private final HashMap<String, Operation> commands;
    private final Login login;
    private final Executer executer;

    public CustomerView(View view, Executer executer, HashMap<String, Operation> commands, Login login) {
        this.view = view;
        this.executer = executer;
        this.commands = commands;
        this.login = login;
    }
    @Override
    public IView execute() {
        view.show("" + this);
        executer.executeUserCommands(view, commands);
        if (login.status())
            return this;
        else
            return null;
    }

    @Override
    public String toString() {
        String input = "";
        int index = 0;
        String stringIndex = "" +index;
        while (commands.containsKey(stringIndex)) {
            input += stringIndex + " " + commands.get(stringIndex) + '\n';
            stringIndex = "" + ++index;
        }
        return input;
    }
}
