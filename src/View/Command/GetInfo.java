package View.Command;

import View.ConsoleUI;

public class GetInfo extends Command{
    public GetInfo(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Get Info for Family Tree";
    }

    @Override
    public void execute() {
        consoleUI.getInfo();
    }
}
