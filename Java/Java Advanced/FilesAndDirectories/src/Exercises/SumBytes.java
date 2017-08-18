package Exercises;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SumBytes {
    private final static String path = "/src/resources/someText.txt";

    public static void main(String[] args) throws FileNotFoundException {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        String inputPath = projectPath + path;
        File someFile = new File(inputPath);
        FileReader fileReader = new FileReader(someFile);
        long sum = 0;
        try (BufferedReader reader = new BufferedReader(fileReader)) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    sum += c;
                }
            }
            System.out.println(sum);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
