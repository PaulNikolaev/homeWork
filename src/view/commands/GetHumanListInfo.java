package view.commands;

import view.ConsoleUI;

public class GetHumanListInfo extends Command{

    public GetHumanListInfo(ConsoleUI consoleUI) {
        super("Получить список родственников", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getHumanListInfo();
    }
}
