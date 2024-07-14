package service;

import builder.HumanBuilder;
import family_tree.FamilyTree;
import human.Gender;
import human.Human;

import java.time.LocalDate;

public class Service {
    private FamilyTree<Human> familyTree;
    private HumanBuilder humanBuilder;

    private void setFamilyTree(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public Service() {
        familyTree = new FamilyTree<>();
        humanBuilder = new HumanBuilder();
    }

    // Добавление человека в сервис и в семейное дерево
    public Human addHuman(String name, LocalDate birthDate, Gender gender) {
        Human human = humanBuilder.build(name, birthDate, gender);
        familyTree.addHuman(human);
        return human;
    }

    // Установка матери ребенка
    public void setMother(Human child, Human mother) {
        familyTree.setMother(child, mother);
    }

    // Установка отца ребенка
    public void setFather(Human child, Human father) {
        familyTree.setFather(child, father);
    }

    // Поиск человека по ID
    public String findHumanById(int id) {
        Human found = familyTree.findHumanById(id);
        return found != null ? found.toString() : "Человек с ID " + id + " не найден";
    }

    // Поиск человека по имени
    public String findHumanByName(String name) {
        if (name != null) {
            Human found = familyTree.findHumanByName(name);
            return found != null ? found.toString() : "Такого человека нет";
        } else {
            return "Имя не может быть null";
        }
    }

    // Сохранение семейного дерева в файл
    public void saveTree(String filePath) {
        FileHandler fileHandler = new FileHandler(filePath);
        fileHandler.save(familyTree);
    }

    // Чтение семейного дерева из файла и создание нового сервиса
    public static Service readTree(String filePath) {
        FileHandler fileHandler = new FileHandler(filePath);
        FamilyTree familyTree = (FamilyTree) fileHandler.read();
        Service service = new Service();
        service.setFamilyTree(familyTree);
        return service;
    }

    // Сортировка по имени
    public void sortByName() {
        familyTree.sortByName();
    }

    // Сортировка по дате рождения
    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
    }

    // Получение информации о людях в семейном дереве
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
