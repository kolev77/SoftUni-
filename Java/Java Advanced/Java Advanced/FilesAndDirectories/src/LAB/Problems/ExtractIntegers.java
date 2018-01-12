package LAB.Problems;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {
        String inputPath = "..\\FilesAndDirectories\\input.txt";
        String outputPath = "..\\FilesAndDirectories\\ExtractIntOutput.txt";


        try (Scanner scanner = new Scanner(new FileInputStream(inputPath));
             PrintWriter writer = new PrintWriter(outputPath)){
            while (scanner.hasNext()){
                if(scanner.hasNextInt()){
                    writer.println(scanner.nextInt());
                }
                scanner.next();
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
