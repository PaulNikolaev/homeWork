package service;

import builder.HumanBuilder;
import family_tree.FamilyTree;
import human.Gender;
import human.Human;

import java.time.LocalDate;

public class Service {
    private FamilyTree familyTree;
    private HumanBuilder humanBuilder;


    public Service() {
        familyTree = new FamilyTree();
        humanBuilder = new HumanBuilder();
    }

    public Human addHuman(String name, LocalDate birthDate, Gender gender) {
        Human human = humanBuilder.build(name, birthDate, gender);
        familyTree.addHuman(human);
        return human;
    }

    public void setMother(Human child, Human mother) {
        child.setMother(mother);
    }

    public void setFather(Human child, Human father) {
        child.setFather(father);
    }

    public void saveTree(String filePath) {
        FileHandler fileHandler = new FileHandler(filePath);
        fileHandler.save(familyTree);
    }

    public static Service readTree(String filePath) {
        FileHandler fileHandler = new FileHandler(filePath);
        FamilyTree familyTree = (FamilyTree) fileHandler.read();
        Service service = new Service();
        service.setFamilyTree(familyTree);
        return service;
    }

    private void setFamilyTree(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
    }

    public String getHumanListInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Генеалогическое дерево: \n");
        for (Human human : familyTree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
