package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WeakStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Student> students = new ArrayList<>();
        String input = br.readLine();

        while (!input.equals("END")) {
            String[] data = input.split(" ");
            String name = (data[0] + " " + data[1]);
            List<Integer> notes = new ArrayList<>();
            for (int i = 2; i < data.length; i++) {
                notes.add(Integer.valueOf(data[i]));
            }
            students.add(new Student(name, notes));
            input = br.readLine();
        }

        students.stream()
                .filter(x -> {
                    if (x.getNotes().stream().filter(note -> note <= 3).count() >= 2) {
                        return true;
                    } else
                        return false;
                })
                .forEach(x -> System.out.println(x.getFullName()));
    }

    public static class Student {
        private String fullname;

        private List<Integer> notes;

        public List<Integer> getNotes() {
            return this.notes;
        }

        public Student(String fullname, List<Integer> notes) {
            this.fullname = fullname;
            this.notes = notes;

        }

        public String getFullName() {
            return fullname;
        }
    }
}
