package model.family_tree;

import model.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends ItemFamilyTree> implements Serializable, Iterable<E> {
    private List<E> humans;

    public FamilyTree() {
        this.humans = new ArrayList<>();
    }

    // Добавление человека в семейное дерево
    public void addHuman(E human) {
        this.humans.add(human);
    }

    // Установка матери ребенка
    public void setMother(E child, E mother) {
        E childToUpdate = findHumanById(child.getId());
        E motherToUpdate = findHumanById(mother.getId());

        if (childToUpdate != null && motherToUpdate != null) {
            childToUpdate.setMother(motherToUpdate);
            motherToUpdate.addChild(childToUpdate);
        }
    }

    // Установка матери ребенка по ID
    public void setMotherId(long childId, long motherId) {
        E childToUpdate = findHumanById(childId);
        E motherToUpdate = findHumanById(motherId);

        if (childToUpdate != null && motherToUpdate != null) {
            childToUpdate.setMother(motherToUpdate);
            motherToUpdate.addChild(childToUpdate);
        }
    }


    // Установка отца ребенка
    public void setFather(Human child, Human father) {
        E childToUpdate = findHumanById(child.getId());
        E fatherToUpdate = findHumanById(father.getId());

        if (childToUpdate != null && fatherToUpdate != null) {
            childToUpdate.setFather(fatherToUpdate);
            fatherToUpdate.addChild(childToUpdate);
        }
    }

    // Установка отца ребенка по ID
    public void setFatherId(long childId, long fatherId) {
        E childToUpdate = findHumanById(childId);
        E fatherToUpdate = findHumanById(fatherId);

        if (childToUpdate != null && fatherToUpdate != null) {
            childToUpdate.setFather(fatherToUpdate);
            fatherToUpdate.addChild(childToUpdate);
        }
    }
    // Установка родителя ребенка по ID
    public void setParentId(long childId, long parentId) {
        E childToUpdate = findHumanById(childId);
        E parentToUpdate = findHumanById(parentId);

        if (childToUpdate != null && parentToUpdate != null) {
            childToUpdate.setParent(parentToUpdate);
            parentToUpdate.addChild(childToUpdate);
        }
    }


    //Поиск человека по ID
    public E findHumanById(long id) {
        for (E human : humans) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    //Поиск человека по имени
    public E findHumanByName(String name) {
        for (E human : humans) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }
    // Сортировка по имени
    public void sortByName() {
        humans.sort(new HumanComparatorByName<>());
    }

    // Сортировка по дате рождения
    public void sortByBirthDate() {
        humans.sort(new HumanComparatorByBirthDate<>());
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(humans);
    }

    public int familyTreeSize() {
        return humans.size();
    }
}
