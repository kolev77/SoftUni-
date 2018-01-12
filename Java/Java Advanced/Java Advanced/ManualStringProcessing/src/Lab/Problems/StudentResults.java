package Lab.Problems;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class StudentResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, ArrayList<Double>> result = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" - ");
            String name = input[0];
            String[] notesArr = input[1].split(", ");
            double JAdv = Double.valueOf(notesArr[0]);
            double JavaOOP = Double.valueOf(notesArr[1]);
            double AdvOOP = Double.valueOf(notesArr[2]);
            double Average = (JAdv + JavaOOP + AdvOOP) / 3;
            ArrayList<Double> notes = new ArrayList<>();
            notes.add(JAdv);
            notes.add(JavaOOP);
            notes.add(AdvOOP);
            notes.add(Average);
            result.put(name, notes);
        }

        if (!result.isEmpty()) {
            System.out.println(String.format("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|", "Name", "JAdv", "JavaOOP", "AdvOOP", "Average"));
            for (String name : result.keySet()) {
                System.out.println(String.format("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|", name, result.get(name).get(0), result.get(name).get(1), result.get(name).get(2), result.get(name).get(3)).replace('.',','));
            }
        }
    }
}
