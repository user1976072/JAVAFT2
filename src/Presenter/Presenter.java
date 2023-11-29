package Presenter;

import Model.Human.Gender;
import Model.Service;
import View.View;

import java.time.LocalDate;
import java.util.List;

public class Presenter  {
    private View view;
    private Service service;

    public Presenter(View view){
        this.view = view;
        this.service = new Service();
    }

    public void addMembersCons(int id, String name, Gender gender, LocalDate birthdate) {
        service.addMembers(id, name, gender, birthdate);
        view.printAnswer("Человек добавлен");

    }

    public void findIdConnect(long childId, long parentId) {
        List<String> connections = service.findIdConnect(childId, parentId);
        for (String connection: connections) {
            view.printAnswer(connection);
        }
    }

    public void doChildren(long parentId, int id,String childName, Gender childGender, LocalDate childBirthdate) {
        service.doChildren(parentId, id, childName, childGender, childBirthdate);
        view.printAnswer("Child added");
    }

    public void doMarriage(long humanId1, long humanId2) {
        service.doMarriage(humanId1, humanId2);
        getInfo();
    }

    public void getInfo() {
        String info = service.getInfo();
        view.printAnswer(info);
    }

    public void sortByName() {
        service.sortByName();
        getInfo();
    }

    public void sortByAge() {
        service.sortByAge();
        getInfo();
    }

    public void save() {
        service.saveT();
        getInfo();
    }

    public void read() {
        service.readT();
        getInfo();
    }

}
