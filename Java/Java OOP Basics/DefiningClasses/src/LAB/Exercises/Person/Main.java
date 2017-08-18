package LAB.Exercises.Person;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Rostislav Kolev on 08-Mar-17.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        HashMap<String, List<Employee>> employeeMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = br.readLine().split("\\s+");

            Employee employee = null;

            String name = tokens[0];
            double salary = Double.valueOf(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            employeeMap.putIfAbsent(department, new ArrayList<>());

            switch (tokens.length) {
                case 6:
                    String email = tokens[4];
                    int age = Integer.valueOf(tokens[5]);
                    employee = new Employee(name, salary, position, department, email, age);
                    break;
                case 5:
                    try {
                        int otherAge = Integer.parseInt(tokens[4]);
                        employee = new Employee(name, salary, position, department, otherAge);
                    } catch (NumberFormatException err) {
                        String otherEmail = tokens[4];
                        employee = new Employee(name, salary, position, department, otherEmail);
                    }
                    break;
                case 4:
                    employee = new Employee(name, salary, position, department);
                    break;
            }
            employeeMap.get(department).add(employee);
        }
        employeeMap.entrySet().stream()
                .sorted((dep1, dep2) -> Double.compare(
                        dep2.getValue().stream().mapToDouble(e -> e.getSalary()).average().getAsDouble(),
                        dep1.getValue().stream().mapToDouble(e -> e.getSalary()).average().getAsDouble()
                )).limit(1)
                .forEach(dep -> {
                    System.out.printf("Highest Average Salary: %s\n", dep.getKey());
                    dep.getValue().stream()
                            .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                            .forEach(e -> System.out.println(e));
                });

    }
}
