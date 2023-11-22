package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Model.FamTree.FamTree;
import Model.FamTree.TreeInterface;
import Model.Human.Human;



public class Service<E extends TreeInterface<E>> {

    private FamTree<E> famTree;
    private Human human;

    public Service(FamTree<E> famTree, Human human) {
        this.famTree = famTree;
        this.human = human;
    }

    public Service() {famTree = new FamTree<>();}

//    public boolean addMembers(String name, Gender gender, LocalDate birthdate) {
//        Human human = new Human(name, gender, birthdate);
//        return famTree.addMembers((E) human);
//    }

    public List<String> findIdConnect(long childId, long parentId) {
        E child = famTree.getById(childId);
        E parent = famTree.getById(parentId);

        if (child != null && parent != null) {
            List<String> connections = new ArrayList<>();
            connections.add(child.getName() + " ребенок от " + parent.getName());
            connections.add(parent.getName() + " это родитель - " + child.getName());

            if (child.getMarriage() != null) {
                connections.add(child.getName() + " в браке с " + child.getMarriage().getName());
            }
            return connections;
        } else { return Collections.singletonList(" Идентификаторы неверны ");
        }
    }


    public void sortByName() {
        famTree.sortByName();
    }

    public void sortByAge() {
        famTree.sortByAge();
    }

    public String getInfo() {
        return famTree.getInfo();
    }
}

