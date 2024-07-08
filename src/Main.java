import family_tree.FamilyTree;
import human.Gender;
import human.Human;
import writer.FileHandler;


import java.time.LocalDate;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = testTree();
        //FamilyTree familyTree = readTree();
        System.out.println("Генеалогическое дерево:");
        familyTree.printFamilyTree();

        //saveTree(familyTree);



/*        // Получение всех детей отца
        System.out.println("\nДети: " + father.getName());
        List<Human> fathersChildren = familyTree.getChildrenOf(father);
        for (Human child : fathersChildren) {
            System.out.println(child);
        }
        //получение родителей
        System.out.println("\nРодители: " + daughter.getName());
        List<Human> daughterChildren = familyTree.getParentsOf(daughter);
        for (Human parent : daughterChildren) {
            System.out.println(parent);
        }
*/



    }

    private static void saveTree(FamilyTree familyTree) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(familyTree);
    }

    private static FamilyTree readTree () {
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.read();
    }

    private static FamilyTree testTree() {
        FamilyTree familyTree = new FamilyTree();

        // Создание людей
        Human father = new Human("Наумов Алексей", LocalDate.of(1977, 12, 31), Gender.Male);
        Human mather = new Human("Наумова Ольга", LocalDate.of(1980, 8, 12), Gender.Female);
        Human daughter = new Human("Наумова Марина", LocalDate.of(2000, 6, 21), Gender.Female);
        Human son = new Human("Наумов Павел", LocalDate.of(2008, 5, 10), Gender.Male);

        // Добавление в семейное дерево
        familyTree.addHuman(father);
        familyTree.addHuman(mather);
        familyTree.addHuman(daughter);
        familyTree.addHuman(son);

        //Устанавливаем семейные связи
        familyTree.addChild(father, daughter);
        familyTree.addChild(mather, daughter);
        familyTree.addChild(father, son);
        familyTree.addChild(mather, son);

        Human grandmother = new Human("Наумова Раиса", LocalDate.of(1932, 5, 31), Gender.Female);

        familyTree.addHuman(grandmother);
        familyTree.addChild(grandmother, father);

        return familyTree;
    }

}