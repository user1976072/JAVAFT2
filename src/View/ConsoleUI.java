package View;

import Model.Human.Gender;
import Presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
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

    public void save() {presenter.save();}

    public void read() {presenter.read();}

    public void doMarriage() {
        System.out.println(" Введите первый Id вступающего в брак: ");
        int humanId1 = Integer.parseInt(scanner.nextLine());
        System.out.println(" Введите второй Id вступающего в брак: ");
        int humanId2 = Integer.parseInt((scanner.nextLine()));
        presenter.doMarriage(humanId1, humanId2);
    }

    public void doChildren() {
        System.out.println(" Введите Id родителя: ");
        String parentIdStr = scanner.nextLine();
        int parentId = Integer.parseInt(parentIdStr);
        System.out.println("Enter Id child: ");
        String childIdStr = scanner.nextLine();
        int childId = Integer.parseInt(childIdStr);
        System.out.println(" Enter name child for added to parent: ");
        String childName = scanner.nextLine();
        System.out.println(" Enter child gender (Male/Female):");
        Gender childGender = Gender.valueOf(scanner.nextLine());
        System.out.println("Enter birthdate child for added to parent (ee-mm-dd): ");
        LocalDate childBirthdate = LocalDate.parse(scanner.nextLine());
        presenter.doChildren(parentId, childId, childName, childGender, childBirthdate);
    }

    public void findIdConnect() {
        System.out.println(" Введите идентификатор ребенка: ");
        String childIdStr = scanner.nextLine();
        int childId = Integer.parseInt(childIdStr);
        System.out.println(" Введите идентификатор родителя: ");
        String parentIdStr = scanner.nextLine();
        int parentId = Integer.parseInt(parentIdStr);
        presenter.findIdConnect(childId, parentId);
    }

    public void addMembersCons() {
        System.out.println(" Enter Id ");
        String idStr = scanner.nextLine();
        int id = Integer.parseInt(idStr);
        System.out.println("Enter name your member's the family tree: ");
        String name = scanner.nextLine();
        System.out.println("Enter your gender (Male/Female): ");
        Gender gender = Gender.valueOf(scanner.nextLine());
        System.out.println("Enter age your member's the family tree (ee-mm-dd): ");
        LocalDate birthdate = LocalDate.parse(scanner.nextLine());
        presenter.addMembersCons(id, name, gender, birthdate);
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
