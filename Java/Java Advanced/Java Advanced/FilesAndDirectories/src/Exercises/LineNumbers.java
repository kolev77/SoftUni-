package Exercises;

import java.io.*;

public class LineNumbers {
    private final static String input = "/src/resources/myBook.txt";
    private final static String output = "/src/resources/LineNumbers.txt";

    public static void main(String[] args) throws FileNotFoundException {
        String projectPath = System.getProperty("user.dir");
        String inputPath = projectPath + input;
        String outputPath = projectPath + output;
        File inputFile = new File(inputPath);
        FileReader fileReader = new FileReader(inputFile);

        try (BufferedReader reader = new BufferedReader(fileReader); PrintWriter writer = new PrintWriter(outputPath)) {
            String line = "";
            int lineCounter = 1;
            while ((line = reader.readLine()) != null) {
                String editedLine = lineCounter + ". " + line;
                writer.println(editedLine);
                lineCounter++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
