package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Rostislav Kolev on 09-Jul-17.
 */
public class SortStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Student> students = new ArrayList<>();
        String input = br.readLine();

        while (!input.equals("END")) {
            String[] data = input.split(" ");
            Student current = new Student(data[0], data[1]);
            students.add(current);
            input = br.readLine();
        }

        students.stream().sorted((x1, x2) -> x2.getFirst_name().compareTo(x1.getFirst_name()))
                .sorted((x1, x2) -> x1.getLast_name().compareTo(x2.getLast_name()))
                .forEach(x -> System.out.println(x.getFirst_name() + " " + x.getLast_name()));
    }

    public static class Student {
        private String first_name;
        private String last_name;

        public Student(String first_name, String last_name) {
            this.first_name = first_name;
            this.last_name = last_name;
        }

        public String getFirst_name() {
            return first_name;
        }

        public String getLast_name() {
            return last_name;
        }
    }
}
