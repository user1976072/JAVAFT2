package Model;

import Model.FamTree.FamTree;
import Model.Human.Gender;
import Model.Human.Human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Service {

    private FamTree<Human> famTree;
    private HumanBuild builder;

    public Service() {
        famTree = new FamTree();
        builder = new HumanBuild();
    }

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

    public void addMembers(int id, String name, Gender gender, LocalDate birthdate) {
        Human human = builder.build(id, name, gender, birthdate);
        famTree.addMembers(human);
    }

    public void doMarriage(long humanId1, long humanId2) {
        Human human1 = famTree.getById(humanId1);
        Human human2 = famTree.getById(humanId2);

        if (human1 != null && human2 != null) {
            if (famTree.setWedding(human1, human2)) {
                System.out.println(" Свадьба между " + human1.getName() + " и " + human2.getName() + "прошла успешно");
            } else {
                System.out.println(" Error при установки свадьбы");
            }
        } else {
            System.out.println((" Один из людей не найден "));
        }
    }

    public void doChildren(long parentId, int id, String childName, Gender childGender, LocalDate childBirthdate) {
         Human parent = famTree.getById(parentId);

        if (parent != null) {
            Human child = builder.build(id, childName, childGender, childBirthdate);
            famTree.addMembers(child);
            if (parent.addChild(child)) {
                System.out.println(child.getName() + " добавлен как ребенок " + parent.getName());
            } else {
                System.out.println(" Error при добавлении child");
            }
        } else {
            System.out.println(("Родитель с идентификатором " + parentId + "не найден"));
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

    public void saveT() { famTree.save("src/Model/Writer/FTree.txt"); }

    public void readT() {famTree.read("src/Model/Writer/FTree.txt"); }

}


