package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StudentsEnrolled {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Student> students = new ArrayList<>();
        String input = br.readLine();

        while (!input.equals("END")) {
            String[] data = input.split(" ");
            String faculty_number = (data[0]);
            List<String> notes = new ArrayList<>();
            for (int i = 1; i < data.length; i++) {
                notes.add(data[i]);
            }
            students.add(new Student(faculty_number, notes));
            input = br.readLine();
        }

        students.stream()
                .filter(x -> x.getFacultyNumber().endsWith("14") || x.getFacultyNumber().endsWith("15"))
                .forEach(x -> System.out.println(String.join(" ", x.getNotes())));

    }

    public static class Student {
        private String facultyNumber;

        private List<String> notes;

        public List<String> getNotes() {
            return this.notes;
        }

        public Student(String facultyNumber, List<String> notes) {
            this.facultyNumber = facultyNumber;
            this.notes = notes;

        }

        public String getFacultyNumber() {
            return facultyNumber;
        }
    }
}
