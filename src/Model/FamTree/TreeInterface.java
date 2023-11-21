package Model.FamTree;



import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeInterface<E> extends Serializable {
    boolean addParents(E parents);
    boolean addChild(E child);
    List<E> getChildren();
    String getName();
    LocalDate getBirthdate();
    LocalDate getDeathdate();
    void setChildren(List<E> children);
    void setMother(E mother);
    void setFather(E father);
    List<E> getParents();
    int getAge();
    void setMarriage(E marriage);
    E getMarriage();
    void setId(long l);
    long getId();
}
