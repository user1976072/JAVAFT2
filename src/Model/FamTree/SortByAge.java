package Model.FamTree;

import java.util.Comparator;

public class SortByAge<E extends TreeInterface<E>> implements Comparator<E> {
    public int compare(E o1, E o2) {
                return o1.getAge() - o2.getAge();
            }
}
