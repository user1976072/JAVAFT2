package View.Command;

import View.ConsoleUI;

public class GetInfoTree extends Command{
    public GetInfoTree(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Get Info for Family Tree";
    }

    @Override
    public void execute() {
        consoleUI.getInfoTree();
    }
}
