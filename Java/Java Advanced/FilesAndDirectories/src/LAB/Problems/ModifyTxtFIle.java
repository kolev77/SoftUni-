package LAB.Problems;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;

public class ModifyTxtFIle {
    public static void main(String[] args) {
        String inputPath = "..\\FilesAndDirectories\\input.txt";
        String outputPath = "..\\FilesAndDirectories\\output.txt";
        HashSet<Character> punctuation = new HashSet<>();
        Collections.addAll(punctuation, ',', '.', '!', '?');

        try (FileInputStream fis = new FileInputStream(inputPath);
             FileOutputStream fos = new FileOutputStream(outputPath)) {
            int oneByte = fis.read();
            while (oneByte >= 0) {
                if (!punctuation.contains((char) oneByte)) {
                    fos.write(oneByte);
                }
                oneByte = fis.read();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
