package CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,List<Employee>> employeesByDep = new HashMap<>();
        int n = Integer.valueOf(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("\\s+");
            String name = input[0];
            double salary = Double.valueOf(input[1]);
            String position = input[2];
            String department = input[3];
            if (input.length <5){
                Employee employee = new Employee(name,salary,position,department);
                importEmployee(employee,employeesByDep);

            } else if( input.length < 6){
                if (input[4].matches("\\d+")){
                    int age = Integer.valueOf(input[4]);
                    Employee employee = new Employee(name,salary,position,department,age);
                    importEmployee(employee,employeesByDep);
                } else {
                    String email = input[4];
                    Employee employee = new Employee(name,salary,position,department,email);
                    importEmployee(employee,employeesByDep);
                }
            } else if (input.length >5){
                String email = input[4];
                int age = Integer.valueOf(input[5]);
                Employee employee = new Employee(name,salary,position,department,email,age);
                importEmployee(employee,employeesByDep);
            }
        }

        employeesByDep.entrySet()
                .stream()
                .sorted((d1,d2) -> Double.compare(d2.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble(),
                        d1.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble()))
                .limit(1)
                .forEach(d -> {
                    StringBuilder sb = new StringBuilder(String.format("Highest Average Salary: %s\n", d.getKey()));
                    d.getValue().stream()
                            .sorted((e1,e2) -> Double.compare(e2.getSalary(),e1.getSalary()))
                            .forEach(e-> sb.append(e).append("\n"));
                    System.out.println(sb.toString());
                });

    }
   public static void importEmployee(Employee employee,HashMap<String,List<Employee>> employeeByDep){
        if(!employeeByDep.containsKey(employee.getDepartment())){
            List<Employee> employees = new ArrayList<>();
            employees.add(employee);
            employeeByDep.put(employee.getDepartment(),employees);
        } else {
            List<Employee> employees = employeeByDep.get(employee.getDepartment());
            employees.add(employee);
            employeeByDep.put(employee.getDepartment(),employees);
        }
    }
}

