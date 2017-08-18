package LAB.SortPerson;

public class Person {
    private String firstName;
    private String lastName;
    private Integer age;

    public Person(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Integer getAge() {
        return this.age;
    }

    private String getLastName() {

        return this.lastName;
    }
    public String getFirstName() {

        return this.firstName;
    }

    @Override
    public String toString() {
        return this.getFirstName() + " " + this.getLastName() + " is a " + this.getAge() + " years old.";
    }
}
