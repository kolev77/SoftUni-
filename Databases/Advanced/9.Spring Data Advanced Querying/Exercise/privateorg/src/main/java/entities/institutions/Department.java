package entities.institutions;

import entities.positions.Employee;
import entities.positions.SuperiorEmployee;

import javax.persistence.*;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "departments")
public class Department {
    private Long id;
    private Set<Employee> employees;
    private SuperiorEmployee headOfDepartment;
    private Administration administration;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "department_employee",
            joinColumns =
            @JoinColumn(name = "dep_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "head_of_department")
    public SuperiorEmployee getHeadOfDepartment() {
        return headOfDepartment;
    }

    public void setHeadOfDepartment(SuperiorEmployee headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "department_administration_id")
    public Administration getAdministration() {
        return administration;
    }

    public void setAdministration(Administration administration) {
        this.administration = administration;
    }
}
