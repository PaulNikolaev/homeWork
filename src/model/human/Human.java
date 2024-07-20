package model.human;

import model.family_tree.ItemFamilyTree;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, ItemFamilyTree<Human> {
    private long id;
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private Human mother, father;
    private List<Human> children;

    public Human(long id, String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human mother, Human father) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
    }

    public Human(long id, String name, Gender gender, LocalDate birthDate) {
        this(id, name, gender, birthDate, null, null, null);
    }

    public Human(long id, String name, Gender gender, LocalDate birthDate, Human mother, Human father) {
        this(id, name, gender, birthDate, null, mother, father);
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public Gender getGender() {
        return gender;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setParent(Human parent) {
        if (parent.gender.equals(Gender.Female)){
            setMother(parent);
        } else if (parent.gender.equals(Gender.Male)) {
            setFather(parent);
        }
    }

    public void addChild(Human child) {
        if(!children.contains(child)) {
            children.add(child);
        }
    }

    private String formatBirthDate(LocalDate birthDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy 'г.'");
        return birthDate.format(formatter);
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
        sb.append(getGenderInfo());
        sb.append(", дата рождения: ");
        sb.append(formatBirthDate(birthDate));
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    private String getGenderInfo(){
        String res = "";
        if (gender.equals(Gender.Female)) {
            res += "женский";
        } else if (gender.equals(Gender.Male)) {
            res += "мужской";
        }
        return res;
    }

    private String getMotherInfo() {
        String res = "мать: ";
        String motherName = (mother != null) ? mother.getName() : "нет";
        res += motherName;
        return res;
    }

    private String getFatherInfo() {
        String res = "отец: ";
        String fatherName = (father != null) ? father.getName() : "нет";
        res += fatherName;
        return res;
    }

    private String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (!children.isEmpty()) {
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
