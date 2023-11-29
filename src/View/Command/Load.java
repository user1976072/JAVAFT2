package View.Command;

import View.ConsoleUI;

public class Load extends Command {

    public Load(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Load your FTree on file";
    }

    @Override
    public void execute() {
        consoleUI.read();
    }
}
