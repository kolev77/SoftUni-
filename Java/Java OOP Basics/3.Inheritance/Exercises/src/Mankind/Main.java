package Mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] studentInfo = br.readLine().split("\\s+");
            String[] workerInfo = br.readLine().split("\\s+");

            String studentFirstName = studentInfo[0];
            String studentLastName = studentInfo[1];
            String facultyNumber = studentInfo[2];
            Student student = new Student(studentFirstName, studentLastName, facultyNumber);

            String workerFirstName = workerInfo[0];
            String workerLastName = workerInfo[1];
            double weekSalary = Double.parseDouble(workerInfo[2]);
            double hoursPerDay = Double.parseDouble(workerInfo[3]);

            Worker worker = new Worker(workerFirstName, workerLastName, weekSalary, hoursPerDay);
            
            System.out.println(student);
            System.out.println();
            System.out.println(worker);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }


    }

}
