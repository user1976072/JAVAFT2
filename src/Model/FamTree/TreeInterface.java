package Model.FamTree;



import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeInterface<Human> extends Serializable {
    boolean addParents(Human parents);
    boolean addChild(Human child);
    List<Human> getChildren();
    String getName();
    LocalDate getBirthdate();
    LocalDate getDeathdate();
    void setChildren(List<Human> children);
    void setMother(Human mother);
    void setFather(Human father);
    List<Human> getParents();
    int getAge();
    void setMarriage(Human marriage);
    Human getMarriage();
    void setId(long l);
    long getId();
    String getInfo();
}
