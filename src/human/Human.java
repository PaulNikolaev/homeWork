package human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private String name;
    LocalDate birthDate;
    Gender gender;
    Human mother, father;
    List<Human> children;

    public Human(String name, LocalDate birthDate, Gender gender, Human mather, Human father) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.mother = mather;
        this.father = father;
        this.children = new ArrayList<>();
    }

    public Human(String name, LocalDate birthDate, Gender gender) {
        this(name, birthDate, gender, null, null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void addChild(Human child) {
        this.children.add(child);
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public void addChildren(Human children) {
        this.children.add(children);
    }


    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ");
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
