package Presenter;

import Model.FamTree.TreeInterface;
import Model.Human.Gender;
import Model.Human.Human;
import Model.Service;
import View.View;

import java.time.LocalDate;
import java.util.List;

public class Presenter<Human extends TreeInterface<Human>>  {
    private View view;
    private Service service;

    public Presenter(Service service, View view){
        this.view = view;
        this.service = service;
    }

    public void addMembersToConsole(Model.Human.Human human) {
        service.addMembers(human);
        if(human != null) {
            view.printAnswer("Человек добавлен");
        } else {view.printAnswer("Ошибка при добавлении");}

    }

    public void findIdConnect(long childId, long parentId) {
        List<String> connections = service.findIdConnect(childId, parentId);
        for (String connection: connections) {
            view.printAnswer(connection);
        }
    }

//    private void setWeddings() {
//        service
//        getInfoTree();
//    }

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
}
