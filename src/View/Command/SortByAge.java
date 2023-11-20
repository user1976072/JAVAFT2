package View.Command;

import View.ConsoleUI;

public class SortByAge extends Command{
    public SortByAge(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Sort Family tree by the age";
    }

    @Override
    public void execute() {
        consoleUI.sortByAge();
    }
}
