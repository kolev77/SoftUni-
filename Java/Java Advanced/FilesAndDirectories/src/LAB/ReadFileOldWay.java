package LAB;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFileOldWay {
    public static void main(String[] args) {
        String path = "E:\\softuni.txt";
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
            int oneByte = fis.read();
            while (oneByte >=0){
                System.out.println(oneByte);
                oneByte = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fis != null){  // could throw exception
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
