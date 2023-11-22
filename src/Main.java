import Model.FamTree.TreeInterface;
import Model.Human.Gender;
import Model.Human.Human;
import Model.Writer.FileHandler;
import Model.FamTree.FamTree;
import View.ConsoleUI;
import View.View;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
//        String filePath = "src/Fam_Tree/Writer/FTree.txt";
        //        FamTree tree = testTree();
//        FamilyTree tree = load();
//        System.out.println(tree);

        View view = new ConsoleUI();
        view.start();

//        save(tree);
//        tree.sortByName();
//        System.out.println(tree);
//        System.out.println("-".repeat(16));
//        tree.sortByAge();
//        System.out.println(tree);
    }
//    private static FamTree load() {
//        FileHandler fileHand = new FileHandler();
//        String filePath = "scr/Fam_Tree/Writer/FTree.txt";
//        return (FamTree) fileHand.read(filePath);
//    }

//    private static void save (FamTree tree) {
//        FileHandler fileHand = new FileHandler();
//        String filePath = "scr/Fam_Tree/Writer/FTree.txt";
//        fileHand.save(tree, filePath);
//    }
//    Fam_Tree.Writer.FileHandler fileHand = new Fam_Tree.Writer.FileHandler();
//        fileHand.save(tree, filePath);
//        fileHand.read(filePath);

//    static FamTree testTree() {
//        FamTree tree = new FamTree();
//
//        Human ivan = new Human("Иван", Gender.Male, LocalDate.of(1919,12,12));
//        Human elena = new Human("Елена", Gender.Female, LocalDate.of(1920,1,23));
//        tree.addMembers(ivan);
//        tree.addMembers(elena);
//        tree.setWedding(ivan, elena);
//        Human petya = new Human("Петя", Gender.Male, LocalDate.of(1940,5,20), ivan, elena);
//        Human olya = new Human("Оля", Gend55er.Female, LocalDate.of(1940,7,8), ivan, elena);
//        tree.addMembers(petya);
//        tree.addMembers(olya);
//        Human vera = new Human("Вера", Gender.Female, LocalDate.of(1899,5,8));
//        vera.addChild(ivan);
//        tree.addMembers(vera);
//
//        return tree;
//    }

}