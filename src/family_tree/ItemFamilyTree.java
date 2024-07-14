package family_tree;

import human.Gender;


import java.time.LocalDate;

public interface ItemFamilyTree<E> {
    int getId();
    String getName();
    LocalDate getBirthDate();
    Gender getGender();

    void setMother(E mother);

    void addChild(E childToUpdate);

    void setFather(E fatherToUpdate);
}
