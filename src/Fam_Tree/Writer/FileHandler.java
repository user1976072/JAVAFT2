//package Fam_Tree.Writer;
//
//import java.io.*;
//
//public class FileHandler implements Writable {
//
//    public boolean save(Serializable serializable, String file){
//        try (ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream(file))) {
//            oos.writeObject(serializable);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public Object read(String file) {
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
//            return ois.readObject();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//}
