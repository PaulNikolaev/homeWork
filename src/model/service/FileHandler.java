package model.service;

import java.io.*;

public class FileHandler implements Writer {

    private String filePath = "src/model/saved_tree/familyTree.txt";

    @Override
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }


    @Override
    public void save(Serializable serializable) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(serializable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object read() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
