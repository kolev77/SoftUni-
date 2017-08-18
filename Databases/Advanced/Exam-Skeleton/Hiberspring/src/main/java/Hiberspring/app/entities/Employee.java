package Hiberspring.app.entities;

import javax.persistence.*;


@Entity
@Table(name = "employees")
public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private String position;
    private EmployeeCard card;
    private Branch branch;

    public Employee() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "first_name",nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name",nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "position",nullable = false)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Column(name = "card",unique = true,nullable = false)
    public EmployeeCard getCard() {
        return card;
    }

    public void setCard(EmployeeCard card) {
        this.card = card;
    }

    @Column(name = "branch",nullable = false)
    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
