package model.service;

import model.builder.HumanBuilder;
import model.family_tree.FamilyTree;
import model.human.Gender;
import model.human.Human;

import java.io.Serializable;
import java.time.LocalDate;

public class Service implements Serializable {
    private static final long serialVersionUID = 1L;
    private FamilyTree<Human> familyTree;
    private HumanBuilder humanBuilder;

    private void setFamilyTree(FamilyTree<Human> familyTree) {
        this.familyTree = familyTree;
    }

    public Service() {
        familyTree = new FamilyTree<>();
        humanBuilder = new HumanBuilder();
    }

    // Добавление человека в сервис и в семейное дерево
    public Human addHuman(String name, LocalDate birthDate, Gender gender) {
        Human human = humanBuilder.build(name, gender, birthDate);
        familyTree.addHuman(human);
        return human;
    }

    // Установка матери ребенка
    public void setMother(Human child, Human mother) {
        familyTree.setMother(child, mother);
    }

    // Установка матери ребенка по ID
    public void setMotherId(long childId, long motherId) {
        familyTree.setMotherId(childId, motherId);
    }

    // Установка отца ребенка
    public void setFather(Human child, Human father) {
        familyTree.setFather(child, father);
    }

    // Установка отца ребенка по ID
    public void setFatherId(long childId, long fatherId) {
        familyTree.setFatherId(childId, fatherId);
    }

    // Установка родителя ребенка по ID
    public void setParentId(long childId, long parentId) {
        familyTree.setParentId(childId, parentId);
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
    public void saveTree(Service tree) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree);
    }

    // Чтение семейного дерева из файла и создание нового сервиса
    public Service readTree() {
        FileHandler fileHandler = new FileHandler();
        return (Service) fileHandler.read();
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


    public int familyTreeSize() {
        return familyTree.familyTreeSize();
    }
}
