package view.commands;

import view.ConsoleUI;

public class SetParentId extends Command{

    public SetParentId(ConsoleUI consoleUI) {
        super("Добавить ребенку родителя", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().setParentId();
    }
}
