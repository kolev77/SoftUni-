package kolev.exam.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "employees")
public class Employee {

    private Long id;
    private String firstName;
    private String lastName;
    private String position;
    private EmployeeCard employeeCard;
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

    @NotNull
    @Column(name = "first_name",nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotNull
    @Column(name = "last_name",nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @NotNull
    @Column(name = "position",nullable = false)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @NotNull
    @OneToOne(optional = false)
    @JoinColumn(name = "card_id",referencedColumnName = "id",unique = true)
    public EmployeeCard getEmployeeCard() {
        return employeeCard;
    }

    public void setEmployeeCard(EmployeeCard employeeCard) {
        this.employeeCard = employeeCard;
    }
    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "branch_id",referencedColumnName = "id")
    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
