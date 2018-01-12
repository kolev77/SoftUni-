package LAB;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFileSmarter {
    public static void main(String[] args) {
        String path = "..\\FilesAndDirectories\\input.txt";

        try (FileInputStream fis = new FileInputStream(path)) {
            int oneByte = fis.read();
            while (oneByte >= 0) {
                System.out.println(oneByte);
                oneByte = fis.read();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

