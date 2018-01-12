package Exercises;

import java.io.*;

public class SumLines {
    private final static String path = "\\ExercisesProblems\\text.txt";

    public static void main(String[] args) throws FileNotFoundException {
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + path;


        File someFile = new File(filePath);

        FileReader fileReader = new FileReader(someFile);

        try (BufferedReader reader = new BufferedReader(fileReader)) {
            long sum = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    sum += c;
                }
                System.out.println(sum);
                sum = 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
