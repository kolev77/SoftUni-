package LAB.Seriazable;

import java.io.*;

public class SeralazableLogic {
    public static void main(String[] args) {
        String objectPath = "..\\FilesAndDirectories\\object.ser";
        Cube cube = new Cube();
        cube.color = "green";
        cube.width = 12;
        cube.height = 5;
        cube.depth = 7;
      // SAVE OBJECTS
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(objectPath))){
            oos.writeObject(cube);

        } catch (IOException e) {
            e.printStackTrace();
        }

    // LOAD OBJECTS
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(objectPath)) ){
            Cube loadedCube = (Cube) ois.readObject();
            System.out.println(loadedCube.color);
            System.out.println(loadedCube.width);
            System.out.println(loadedCube.height);
            System.out.println(loadedCube.depth);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

