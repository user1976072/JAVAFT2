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

    @Override
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


    public void addMembers() {
        System.out.println("Enter name your member's the family tree: ");
        String name = scanner.nextLine();
        System.out.println("Enter your gender: ");
        Gender gender = Gender.valueOf(scanner.nextLine());
        System.out.println("Enter LocalDate your member's the family tree: ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());
        presenter.addMembers(name, gender, birthDate);



    }

    public void getInfoTree() {
        presenter.getInfoTree();
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
