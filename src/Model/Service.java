package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Model.FamTree.FamTree;
import Model.FamTree.TreeInterface;
import Model.Human.Human;


public class Service<Human extends TreeInterface<Human>> {

    private FamTree<Human> FamTree;
//    private Model.Human.Human human;

//    public Service(Model.FamTree.FamTree<Human> famTree) {
//        FamTree = famTree;
//    }


    public Service() {
        FamTree = new FamTree<>();
//        this.human = new Model.Human.Human();
    }

    public List<String> findIdConnect(long childId, long parentId) {
        Human child = FamTree.getById(childId);
        Human parent = FamTree.getById(parentId);

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
    public void addMembers(Model.Human.Human human) {
        FamTree.addMembers((Human) human);
    }

    public void sortByName() {
        FamTree.sortByName();
    }

    public void sortByAge() {
        FamTree.sortByAge();
    }

    public String getInfo() {
        return FamTree.getInfo();
    }

}

