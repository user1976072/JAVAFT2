import Fam_Tree.Human.Gender;
import Fam_Tree.Human.Human;
//import Fam_Tree.Writer.FileHandler;
import Fam_Tree.Fam_tree.FamilyTree;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;


public class Main {
    public static void main(String[] args) {
//        String file = "scr/Fam_Tree/Writer/FTree.txt";
        FamilyTree tree = testTree();//load();
//        System.out.println(tree);

//        save(tree);
        tree.SortByName();
        System.out.println(tree);
        System.out.println("-".repeat(16));
        tree.SortByAge();
        System.out.println(tree);
    }
//    private static FamilyTree load() {
//            FileHandler fileHand = new FileHandler();
//            String file = "scr/Fam_Tree/Writer/FTree.txt";
//            return (FamilyTree) fileHand.read(file);
//    }
//        Fam_Tree.Writer.FileHandler fileHand = new Fam_Tree.Writer.FileHandler();
//        fileHand.save(tree, file);
//        fileHand.read(file);
//    private static void save (FamilyTree tree) {
//        FileHandler fileHand = new FileHandler();
//        String file = "scr/Fam_Tree/Writer/FTree.txt";
//        fileHand.save(tree, file);
//    }
    static FamilyTree testTree() {
        FamilyTree tree = new FamilyTree();

        Human ivan = new Human("Иван", Gender.Male, LocalDate.of(1919,12,12));
        Human elena = new Human("Елена", Gender.Female, LocalDate.of(1920,1,23));
        tree.addMembers(ivan);
        tree.addMembers(elena);
        tree.setWedding(ivan, elena);
        Human petya = new Human("Петя", Gender.Male, LocalDate.of(1940,5,20), ivan, elena);
        Human olya = new Human("Оля", Gender.Female, LocalDate.of(1940,7,8), ivan, elena);
        tree.addMembers(petya);
        tree.addMembers(olya);
        Human vera = new Human("Вера", Gender.Female, LocalDate.of(1899,5,8));
        vera.addChild(ivan);
        tree.addMembers(vera);

        return tree;
    }

}