package family_tree;

import human.Gender;
import human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> humans;

    public FamilyTree() {
        this.humans = new ArrayList<>();
    }

    // Добавление человека в семейное дерево
    public void addHuman(Human human) {
        this.humans.add(human);
    }

    public void sortByName() {
        humans.sort(new HumanComparatorByName());
    }

    public void sortByBirthDate() {
        humans.sort(new HumanComparatorByBirthDate());
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humans);
    }

}
