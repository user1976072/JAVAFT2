package Presenter;

import Model.Human.Gender;
import Model.Human.Human;
import Model.Service.Service;


import javax.swing.text.View;
import java.time.LocalDate;

public class Presenter  {
    private View view;
    private Service service;

    public Presenter(View view){
        this.view = view;
        service = new Service();
    }

    public void addMembers(String name, Gender gender, LocalDate birthdate) {
        service.addMembers();
        getInfoTree();
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
