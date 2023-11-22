package View.Command;

import View.ConsoleUI;

import javax.swing.text.View;

public abstract class Command {
    String description;
    ConsoleUI consoleUI;

    public Command(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute();

//    View getView() {
//        return view;
//    }
}

