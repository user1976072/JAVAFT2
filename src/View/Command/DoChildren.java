package View.Command;

import View.ConsoleUI;

public class DoChildren extends Command {

    public DoChildren(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Added child to parents";
    }

    @Override
    public void execute() {
        consoleUI.doChildren();
    }

}
