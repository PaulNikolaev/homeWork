package builder;

import human.Gender;
import human.Human;

import java.time.LocalDate;

public class HumanBuilder {
    private int getId;

    public Human build (String name, LocalDate birthDate, Gender gender) {
        return new Human(getId++, name, birthDate,gender);
    }
}
