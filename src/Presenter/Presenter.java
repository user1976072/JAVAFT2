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

//    public void addMembers(String name, Gender gender, LocalDate birthdate) {
//        if(service.addMembers(name, gender, birthdate)){
//            getInfoTree();
//        } else {view.printAnswer("Ошибка при добавлении");}
//
//    }

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

    public void getInfoTree() {
        String info = service.getInfo();
        view.printAnswer(info);
    }

    public void sortByName() {
        service.sortByName();
        getInfoTree();
    }

    public void sortByAge() {
        service.sortByAge();
        getInfoTree();
    }
}
