package Model.Writer;

import java.io.*;

public class FileHandler implements Writable {

    public boolean save(Serializable serializable, String filePath){
        try (ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream(filePath))) {
            oos.writeObject(serializable);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Object read(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
