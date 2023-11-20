package View.Command;

import View.ConsoleUI;

public class Finish extends Command {

    public Finish(ConsoleUI consoleUI){
        super (consoleUI);
        description = "End your work";
    }

    @Override
    public void execute() {
        consoleUI.finish();
    }
}
