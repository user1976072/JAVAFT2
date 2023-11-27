package View.Command;

import View.ConsoleUI;

public class AddMembers extends Command {

    public AddMembers(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Enter member FTree";
    }

    @Override
    public void execute() {
        consoleUI.addMembers();
    }
}
