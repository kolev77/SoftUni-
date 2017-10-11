package kolev.automapping.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private Date birthdate;
    private Address address;
    private Employee manager;
    private Set<Employee> managedEmployees;

    public Employee() {
        this.managedEmployees = new HashSet<>();
    }

    public Employee(String firstName, String lastName, BigDecimal salary, Date birthdate, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.birthdate = birthdate;
        this.address = address;
        this.managedEmployees = new HashSet<>();
    }

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

    @Column(name = "salary")
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Column(name = "birthdate")
    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    @OneToMany(mappedBy = "manager",cascade = CascadeType.PERSIST)
    public Set<Employee> getManagedEmployees() {
        return managedEmployees;
    }

    public void setManagedEmployees(Set<Employee> managedEmployees) {
        this.managedEmployees = managedEmployees;
    }

    public void addManagedEmplyee(Employee employee) {
        managedEmployees.add(employee);
//        employee.setManager(this);
    }

}
