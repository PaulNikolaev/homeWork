package view.commands;

import view.ConsoleUI;

public class ReadTree extends Command{

    public ReadTree(ConsoleUI consoleUI) {
        super("Загрузить семейное дерево из файла", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().readTree();
    }
}