package entities.positions;

import enums.EmployeePosition;

import javax.persistence.*;

@Entity
public abstract class BaseEmployee {
    private Long id;
    private String firstName;
    private String lastName;
    private String egn;
    private int age;
    private EmployeePosition position;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "egn")
    public String getEgn() {
        return egn;
    }

    public void setEgn(String egn) {
        if (egn.length() != 10) {
            System.out.println("ЕGN must be 10 symbols.");
        } else
            this.egn = egn;
    }

    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(name = "position")
    public EmployeePosition getPosition() {
        return position;
    }

    public void setPosition(EmployeePosition position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return String.format("ID%d full name: %s %s, EGN: %s, age: %d, position - %s", id, firstName, lastName, egn, age, position);
    }
}
