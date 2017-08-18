package LAB.SalaryIncrease;

public class Person {
    private String firstName;
    private String lastName;
    private Integer age;
    private Double salary;

    public Person(String firstName, String lastName, Integer age,Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public Integer getAge() {
        return this.age;
    }

    public Double getSalary(){
        return this.salary;
    }
    private String getLastName() {

        return this.lastName;
    }
    public String getFirstName() {

        return this.firstName;
    }

    public void increaseSalary(int bonus){
        if (this.getAge() < 30){
            this.salary += this.salary * bonus/200;
        }else {
            this.salary += this.salary * bonus/100;
        }
    }

    @Override
    public String toString() {
        return this.getFirstName() + " " + this.getLastName() + " get " + this.getSalary() + " leva";
    }
}
