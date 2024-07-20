package view;

import view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commands;

    public MainMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new ReadTree(consoleUI));
        commands.add(new GetHumanListInfo(consoleUI));
        commands.add(new AddHuman(consoleUI));
        commands.add(new SetParentId(consoleUI));
        commands.add(new SortByName(consoleUI));
        commands.add(new SortByBirthDate(consoleUI));
        commands.add(new SaveTree(consoleUI));
        commands.add(new Finish(consoleUI));
    }
    
    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Меню:\n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public int menuSize() {
        return commands.size();
    }


    public void execute(int choice) {
        Command command = commands.get(choice - 1);
        command.execute();
    }
}
