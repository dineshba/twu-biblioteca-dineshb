package com.twu.biblioteca;

import com.twu.biblioteca.operation.Operation;
import com.twu.biblioteca.operation.Parser;

import java.util.HashMap;

public class UserView implements IView{

    private final Parser parser;
    private final View view;
    private final HashMap<String, Operation> commands;

    public UserView(View view, Parser parser, HashMap<String, Operation> commands) {
        this.view = view;
        this.parser = parser;
        this.commands = commands;
    }
    @Override
    public IView execute() {
        view.show("" + this);
        String input = view.getInput();
        if (input.equals("0"))
            return null;
        if (commands.containsKey(input)) {
            Operation operation = commands.get(input);
            operation.execute();
        }
        return this;
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
