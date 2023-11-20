package View.Command;

import View.ConsoleUI;

public class SortByName extends Command{
    public SortByName(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Sort Family tree by the name";
    }

    @Override
    public void execute() {
        consoleUI.sortByName();
    }
}
