package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import Model.FamTree.FamTree;
import Model.FamTree.TreeInterface;


public class Service<Human extends TreeInterface<Human>> {

    private FamTree<Human> famTree;
    private Scanner scanner;
    private Model.Human.Human human;

    public Service(FamTree<Human> famTree, Scanner scanner) {
        this.famTree = famTree;
        this.scanner = scanner;
        this.human = human;
    }

//    public Service() {
//        famTree = new FamTree<>();
////        this.human = new Model.Human.Human();
//    }

    public List<String> findIdConnect(long childId, long parentId) {
        Human child = famTree.getById(childId);
        Human parent = famTree.getById(parentId);

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
//        System.out.println("Enter name your member's the family tree: ");
//        String name = scanner.nextLine();
//        System.out.println("Enter your gender (Male/Female): ");
//        Gender gender = Gender.valueOf(scanner.nextLine());
//        System.out.println("Enter age your member's the family tree (ear-mm-dd): ");
//        LocalDate birthdate = LocalDate.parse(scanner.nextLine());
//        Human human = (Human) new Model.Human.Human(name, gender, birthdate, null, null, null);
        famTree.addMembers((Human) human);
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

