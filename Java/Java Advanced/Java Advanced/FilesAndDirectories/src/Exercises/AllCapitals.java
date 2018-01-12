package Exercises;

import java.io.*;

public class AllCapitals {
    private final static String input = "/src/resources/AllCapitalsInput.txt";
    private final static String output = "/src/resources/AllCapitalsOutput.txt";

    public static void main(String[] args) throws FileNotFoundException {
        String projectPath = System.getProperty("user.dir");
        String inputPath = projectPath + input;
        String outputPath = projectPath + output;
        File inputFile = new File(inputPath);
        FileReader fileReader = new FileReader(inputFile);

        try (BufferedReader reader = new BufferedReader(fileReader);PrintWriter writer = new PrintWriter(outputPath)) {
            String line = "";
            while ((line = reader.readLine()) != null) {

                writer.println(line.toUpperCase());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
};

