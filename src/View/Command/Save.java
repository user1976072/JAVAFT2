package View.Command;

import View.ConsoleUI;

public class Save extends Command {

    public Save(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Save your FTree on file";
    }

    @Override
    public void execute() {
        consoleUI.save();
    }
}
