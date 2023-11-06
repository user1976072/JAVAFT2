package Fam_Tree.Fam_tree;
import Fam_Tree.Human.Human;
import java.io.Serializable;
import java.util.*;

public class FamilyTree implements Serializable {
    private long humanId;
    public List<Human> humanList;

    public FamilyTree(){ this(new ArrayList<>()); }
    public FamilyTree(List<Human> humanList) { this.humanList = humanList;}

    public long getHumanId() {
        return humanId;
    }

    public void setHumanId(long humanId) {
        this.humanId = humanId;
    }

    public boolean addMembers(Human human) {
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

    public Human getById(long id) {
        if (!checkId(id)){
            return null;
        }
        for (Human human : humanList){
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public List<Human> getSiblings(int id) {
        Human human = getById(id);
        if (human == null) {
            return null;
        }

        List<Human> res = new ArrayList<>();
        for (Human parent: human.getParents()) {
            for (Human child: parent.getChildren()) {
                if (!child.equals(human) && !res.contains(child)) {
                    res.add(child);
                }
            }
        }
        return res;
    }

    public List<Human> getByName(String name) {
        List<Human> res = new ArrayList<>();
        for (Human human: humanList) {
            if (human.getName().equals(name)){
                res.add(human);
            }
        }
        return res;
    }

    public boolean setWedding(long humanId1, long humanId2){
        if (checkId(humanId1) && checkId(humanId2)) {
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
            return setWedding(human1, human2);
        }
        return false;
    }

    public boolean setWedding(Human human1, Human human2) { // Метод свадьбы переписанный
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
            Human e1 = getById(eId1);
            Human e2 = getById(eId2);
            return setDivorce(e1, e2);
        }
        return false;
    }

    public boolean setDivorce(Human e1, Human e2) { // переписанный метод развода
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
            Human human = getById(eId);
            return humanList.remove(human);
        }
        return false;
    }

    private void addToParents(Human human) {
        for (Human parent: human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human) {
        for (Human child: human.getChildren()) {
            child.addParents(human);
        }
    }

    private boolean checkId(long id) { return id < humanId && id >= 0; }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (Human human: humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() { return getInfo(); }

    public void SortByName() {
        humanList.sort(new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    public void SortByAge() {
        humanList.sort(new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                return o1.getAge() - o2.getAge();
            }
        });
    }

}
