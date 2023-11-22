package View.Command;

import View.ConsoleUI;

public class FindIdConnect extends Command{
    public FindIdConnect(ConsoleUI consoleUI){
        super (consoleUI);
        description = " Showing parental ties ";
    }

    @Override
    public void execute() {consoleUI.findIdConnect();}
}
