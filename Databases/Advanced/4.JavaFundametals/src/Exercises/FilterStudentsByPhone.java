package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FilterStudentsByPhone {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Student> students = new ArrayList<>();
        String input = br.readLine();

        while (!input.equals("END")) {
            String[] data = input.split(" ");
            Student current = new Student(data[0], data[1],data[2]);
            students.add(current);
            input = br.readLine();
        }

        students.stream().filter(x->x.getNumber().startsWith("02") || x.getNumber().startsWith("+3592"))
                .forEach(x-> System.out.println(x.getFirst_name()+ " "+ x.getLast_name()));
    }
    public static class Student {
        private String first_name;
        private String last_name;
        private String number;

        public String getNumber() {
            return number;
        }

        public Student(String first_name, String last_name, String number) {
            this.first_name = first_name;
            this.last_name = last_name;
            this.number = number;

        }

        public String getFirst_name() {
            return first_name;
        }

        public String getLast_name() {
            return last_name;
        }
    }
}
