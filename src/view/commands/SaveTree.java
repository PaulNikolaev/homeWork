package view.commands;

import view.ConsoleUI;

public class SaveTree extends Command{

    public SaveTree(ConsoleUI consoleUI) {
        super("Сохранить семейное дерево и завершить работу", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().saveTree();
    }
}
