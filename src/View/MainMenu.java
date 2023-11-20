package View;

import View.Command.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {

    private List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new AddMembers(consoleUI));
        commandList.add(new GetInfoTree(consoleUI));
        commandList.add(new SortByAge(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new Finish(consoleUI));
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список комманд:\n");
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("/n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choise) {
        Command command = commandList.get(choise);
        command.execute();
    }

    public int size() {
        return commandList.size();
    }
}
