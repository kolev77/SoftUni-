package LAB.Problems;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;

public class TextToDecimal {
    public static void main(String[] args) {
        String inputPath = "..\\FilesAndDirectories\\input.txt";
        String outputPath = "..\\FilesAndDirectories\\outputDecimal.txt";

        try (FileInputStream fis = new FileInputStream(inputPath);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            int oneByte = fis.read();

            while (oneByte >= 0) {
                if (oneByte == ' ' || oneByte == '\n') {
                    fos.write(oneByte);
                } else {
                    String decimal = String.valueOf(oneByte);
                    System.out.println(decimal);
                    for (char c : decimal.toCharArray()) {
                        fos.write(c);
                    }
                }
                oneByte = fis.read();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
