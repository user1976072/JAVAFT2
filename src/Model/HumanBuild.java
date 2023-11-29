package Model;

import Model.Human.Gender;
import Model.Human.Human;

import java.time.LocalDate;

public class HumanBuild {
//    private int curId;

    public Human build(int id, String name, Gender gender, LocalDate birthdate) {
        return new Human(id, name, gender, birthdate);
//        return new Human(curId++,name, gender, birthdate);для строки выше
    }
}
