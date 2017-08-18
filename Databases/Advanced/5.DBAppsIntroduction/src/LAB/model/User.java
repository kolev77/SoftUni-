package LAB.model;

import LAB.persistence.Column;
import LAB.persistence.Entity;
import LAB.persistence.Id;

import java.time.LocalDate;

/**
 * Created by Rostislav Kolev on 12-Jul-17.
 */
@Entity(name = "users")
public class User {
    @Id
    private long id;

    @Column(name = "first_name")
    private String name;
    private int age;
    @Column(name = "registration_date")
    private LocalDate registrationDate;

    public User( String name, int age, LocalDate registrationDate) {
        this.name = name;
        this.age = age;
        this.registrationDate = registrationDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}
