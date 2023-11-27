package View;

import Model.Human.Human;

public interface View<Human> {
    void printAnswer(String text);
    void start();
    void findIdConnect();
    void addMembers();
    void getInfo();
    void sortByName();
    void sortByAge();
//    void setWeddings();
    void finish();
}
