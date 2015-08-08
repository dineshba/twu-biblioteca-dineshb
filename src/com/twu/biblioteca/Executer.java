package com.twu.biblioteca;

import com.twu.biblioteca.operation.InvalidOption;
import com.twu.biblioteca.operation.Operation;

import java.util.HashMap;

public class Executer {

    private final InvalidOption invalidOption;

    public Executer(InvalidOption invalidOption) {
        this.invalidOption = invalidOption;
    }

    public void execute(View view, HashMap<String, Operation> commands) {
        String input = view.getInput();
        if (commands.containsKey(input)) {
            Operation operation = commands.get(input);
            operation.execute();
        }
        else
            invalidOption.execute();
    }
}
