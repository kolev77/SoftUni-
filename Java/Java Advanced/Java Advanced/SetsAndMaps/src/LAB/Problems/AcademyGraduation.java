package LAB.Problems;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int students = Integer.valueOf(scanner.nextLine());
        TreeMap<String, Double[]> results = new TreeMap<>();
        for (int i = 0; i < students; i++) {
            String name = scanner.nextLine();
            String[] dataScores = scanner.nextLine().split(" ");

            Double[] scores = new Double[dataScores.length];
            for (int j = 0; j < dataScores.length; j++) {
                scores[j] = Double.parseDouble(dataScores[j]);
            }
            results.put(name, scores);
        }
        for (String stud : results.keySet()) {
            Double[] sc = results.get(stud);
            double averageScores = 0;
            for (int j = 0; j < sc.length; j++) {
                averageScores += sc[j];
            }
            System.out.println(stud + " is graduated with " + averageScores / sc.length);
        }
    }
}
