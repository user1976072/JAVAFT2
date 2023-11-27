package View;

import Model.FamTree.FamTree;
import Model.FamTree.TreeInterface;
import Model.Human.Gender;
import Model.Human.Human;
import Model.Service;
import Presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI<Human extends TreeInterface<Human>> implements View<Human> {
    private Scanner scanner;
    private Presenter<Human> presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }


    public void printAnswer(String text) {
        System.out.println(text);
    }

    public void start() {
        System.out.println("Hello");
        while (work) {
            printMenu();
            execute();
        }
    }

    public void finish() {
        System.out.println("Exit");
        work = false;
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void findIdConnect() {
        System.out.println(" Введите идентификатор ребенка: ");
        int childId = Integer.parseInt(scanner.nextLine());
        System.out.println(" Введите идентификатор родителя: ");
        int parentId = Integer.parseInt(scanner.nextLine());
        presenter.findIdConnect(childId, parentId);
    }


    public void addMembers() {
        System.out.println("Enter name your member's the family tree: ");
        String name = scanner.nextLine();
        System.out.println("Enter your gender (Male/Female): ");
        Gender gender = Gender.valueOf(scanner.nextLine());
        System.out.println("Enter age your member's the family tree (ear-mm-dd): ");
        LocalDate birthdate = LocalDate.parse(scanner.nextLine());
        Model.Human.Human human = new Model.Human.Human(name, gender, birthdate);
        presenter.addMembers((Human) human);

    }

    public void getInfo() {
        presenter.getInfo();
    }

    public void printMenu() {
        System.out.println(menu.print());
    }

    public void execute() {
        String date = scanner.nextLine();
        if (cheakStrForInt(date)) {
            int numC = Integer.parseInt(date);
            if (cheakMenu(numC)) {
                menu.execute(numC);
            }
        }
    }

    public boolean cheakStrForInt(String text) {
        if (text.matches("[0-9]+")) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    public boolean cheakMenu(int numC) {
        if (numC < menu.size()) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void inputError() {
        System.out.println("Incorrect Date");
    }

}
