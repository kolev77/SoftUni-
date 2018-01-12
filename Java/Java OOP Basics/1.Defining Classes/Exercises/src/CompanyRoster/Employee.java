package CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Employee {
    private static final String DEFAULT_EMAIL = "n/a";
    private static final int DEFAULT_AGE =  -1;
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public Employee(String name, double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.age = DEFAULT_AGE;
        this.email= DEFAULT_EMAIL;
    }

    public Employee(String name, double salary, String position, String department, int age) {
        this(name,salary,position,department);
        this.age = age;
    }

    public Employee(String name, double salary, String position, String department, String email) {
        this(name,salary,position,department);
        this.email = email;
    }

    public Employee(String name, double salary, String position, String department, String email, int age) {
        this(name,salary,position,department);
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    private void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d",this.getName(),this.getSalary(),this.getEmail(),this.getAge()) ;
    }

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
