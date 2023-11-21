package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Model.FamTree.FamTree;
import Model.FamTree.TreeInterface;
import Model.Human.Gender;
import Model.Human.Human;


public class Service<E extends TreeInterface<E>> {

    private FamTree<E> famTree;
    private Human human;

    public Service(FamTree<E> famTree, Human human) {
        this.famTree = famTree;
        this.human = human;
    }

    public Service() {famTree = new FamTree<>();}

    public boolean addMembers(String name, Gender gender, LocalDate birthdate) {
        Human human = new Human(name, gender, birthdate);
        return famTree.addMembers((E) human);
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

