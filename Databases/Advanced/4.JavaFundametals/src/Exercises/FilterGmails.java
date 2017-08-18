package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rostislav Kolev on 09-Jul-17.
 */
public class FilterGmails {
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

        students.stream().filter(x->x.email.endsWith("gmail.com"))
                .forEach(x-> System.out.println(x.getFirst_name() + " "+ x.getLast_name()));
    }

    public static class Student {
        private String first_name;
        private String last_name;
        private String email;

        public String getEmail() {
            return email;
        }

        public Student(String first_name, String last_name, String email) {
            this.first_name = first_name;
            this.last_name = last_name;
            this.email = email;

        }

        public String getFirst_name() {
            return first_name;
        }

        public String getLast_name() {
            return last_name;
        }
    }
}
