package Model.FamTree;

import java.util.Comparator;

public class SortByAge<Human extends TreeInterface<Human>> implements Comparator<Human> {
    public int compare(Human o1, Human o2) {
                return o1.getAge() - o2.getAge();
            }
}
