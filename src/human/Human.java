package human;

import family_tree.ItemFamilyTree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, ItemFamilyTree {
    private int id;
    private String name;
    private LocalDate birthDate;
    private Gender gender;
    private Human mother, father;
    private List<Human> children;

    public Human(int id, String name, LocalDate birthDate, Gender gender, Human mather, Human father) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.mother = mather;
        this.father = father;
        this.children = new ArrayList<>();
    }

    public Human(int id, String name, LocalDate birthDate, Gender gender) {
        this(id, name, birthDate, gender, null, null);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public LocalDate getBirthDate() {
        return birthDate;
    }


    public Gender getGender() {
        return gender;
    }


    @Override
    public void setMother(Object mother) {

    }

    @Override
    public void addChild(Object childToUpdate) {

    }

    @Override
    public void setFather(Object fatherToUpdate) {

    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ");
        sb.append(id);
        sb.append(", Имя: ");
        sb.append(name);
        sb.append(", пол: ");
        sb.append(getGender());
        sb.append(", дата рождения: ");
        sb.append(birthDate);
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    public String getMotherInfo() {
        String res = "мать: ";
        String motherName = (mother != null) ? mother.getName() : "нет";
        res += motherName;
        return res;
    }

    public String getFatherInfo() {
        String res = "отец: ";
        String fatherName = (father != null) ? father.getName() : "нет";
        res += fatherName;
        return res;
    }

    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (children.size() != 0) {
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
    }


}
