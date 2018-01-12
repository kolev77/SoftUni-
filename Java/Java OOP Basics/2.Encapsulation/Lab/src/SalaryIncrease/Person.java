package SalaryIncrease;

public class Person {
    private String firstName;
    private String lastName;
    private Integer age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + " gets " + this.salary + " leva";
    }

    public void increaseSalary(double bonus) {
        if (this.age <= 30) {
            bonus /= 2;
        }
        this.setSalary(this.getSalary() + this.getSalary() * bonus / 100);
    }
}
