package Model.FamTree;
import java.io.Serializable;
import java.util.*;

public class FamTree<E extends TreeInterface<E>> implements Serializable, Iterable<E> {

    private long humanId;
    public List<E> humanList;

    public FamTree(){ this(new ArrayList<>()); }
    public FamTree(List<E> humanList) { this.humanList = humanList;}

    public long getHumanId() {
        return humanId;
    }

    public void setHumanId(long humanId) {
        this.humanId = humanId;
    }

    public boolean addMembers(E human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)){
            humanList.add(human);
            human.setId(humanId++);

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    public E getById(long id) {
        if (!checkId(id)){
            return null;
        }
        for (E human : humanList){
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public List<E> getSiblings(int id) {
        E human = getById(id);
        if (human == null) {
            return null;
        }

        List<E> res = new ArrayList<>();
        for (E parent: human.getParents()) {
            for (E child: parent.getChildren()) {
                if (!child.equals(human) && !res.contains(child)) {
                    res.add(child);
                }
            }
        }
        return res;
    }

    public List<E> getByName(String name) {
        List<E> res = new ArrayList<>();
        for (E human: humanList) {
            if (human.getName().equals(name)){
                res.add(human);
            }
        }
        return res;
    }

    public boolean setWedding(long humanId1, long humanId2){
        if (checkId(humanId1) && checkId(humanId2)) {
            E human1 = getById(humanId1);
            E human2 = getById(humanId2);
            return setWedding(human1, human2);
        }
        return false;
    }

    public boolean setWedding(E human1, E human2) { // Метод свадьбы переписанный
        if (human1.getMarriage() == null && human2.getMarriage() == null) {
            human1.setMarriage(human2);
            human2.setMarriage(human1);
            return true;
        } else {
            return false;
        }
    }

    public boolean setDivorce(long eId1, long eId2){ // метод развода
        if (checkId(eId1) && checkId(eId2)) {
            E e1 = getById(eId1);
            E e2 = getById(eId2);
            return setDivorce(e1, e2);
        }
        return false;
    }

    public boolean setDivorce(E e1, E e2) { // переписанный метод развода
        if (e1.getMarriage() != null && e2.getMarriage() != null) {
            e1.setMarriage(null);
            e2.setMarriage(null);
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(long eId) { // метод удаления
        if (checkId(eId)) {
            E human = getById(eId);
            return humanList.remove(human);
        }
        return false;
    }

    private void addToParents(E human) {
        for (E parent: human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(E human) {
        for (E child: human.getChildren()) {
            child.addParents(human);
        }
    }

    private boolean checkId(long id) { return id < humanId && id >= 0; }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (E human: humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() { return getInfo(); }

    public void sortByName() {
        humanList.sort(new SortByName());
    }

    public void sortByAge() {
        humanList.sort(new SortByAge());
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator();
    }

    public class HumanIterator implements Iterator<E> {
        private int index;
        private List<E> humanList;

        @Override
        public boolean hasNext() {
            return index < humanList.size();
        }

        @Override
        public E next() {
            return humanList.get(index++);
        }
    }

}
