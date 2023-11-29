package View.Command;

import View.ConsoleUI;

public class DoMarriage extends Command {

    public DoMarriage(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Enter Id members FTree for Marriage ";
    }

    @Override
    public void execute() {
        consoleUI.doMarriage();
    }

}
