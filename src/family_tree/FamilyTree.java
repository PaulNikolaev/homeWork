package family_tree;

import human.Gender;
import human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    // Добавление человека в семейное дерево
    public void addHuman(Human human) {
        this.members.add(human);
    }

    //    Добавление родственных связей ребенок - родитель
    public void addChild(Human parent, Human child) {
        if (parent == null || child == null) {
            throw new IllegalArgumentException("Родитель или ребенок не могут быть равны нулю.");
        }

        if (!parent.getChildren().contains(child)) {
            parent.addChild(child);
        }

        if (parent.getGender().equals(Gender.Female)) {
            if (child.getMother() == null || !child.getMother().equals(parent)) {
                child.setMother(parent);
            }
        } else {
            if (child.getFather() == null || !child.getFather().equals(parent)) {
                child.setFather(parent);
            }
        }
    }

    public List<Human> getChildrenOf(Human human) {
        return human.getChildren();
    }

    public List<Human> getParentsOf(Human human) {
        List<Human> parents = new ArrayList<>();
        parents.add(human.getFather());
        parents.add(human.getMother());
        return parents;
    }

    // Поиск человека по имени
    public Human findPersonByName(String name) {
        for (Human human : members) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    // Печать всех членов дерева
    public void printFamilyTree() {
        for (Human human : members) {
            System.out.println(human);
        }
    }
}
