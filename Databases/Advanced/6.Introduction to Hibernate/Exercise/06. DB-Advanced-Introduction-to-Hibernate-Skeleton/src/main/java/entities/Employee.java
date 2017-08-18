package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employee {
    private Integer id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String jobTitle;
    private Department department;
    private Employee manager;
    private Timestamp hireDate;
    private BigDecimal salary;
    private Address address;
    private Set<Project> projects;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Column(name = "middle_name")
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Column(name = "job_title")
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")  // many employees have one department
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "employee_id")   // Many employees have one manager.
    public Employee getManager() { // Must take the id column which name we set to "employee_id" and join to new column with suitable name.
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    @Column(name = "hire_date")
    public Timestamp getHireDate() {
        return hireDate;
    }

    public void setHireDate(Timestamp hireDate) {
        this.hireDate = hireDate;
    }

    @Column(name = "salary")
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @ManyToOne  // Many employees joined to one address
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")   // we create new column "address_id" in Employee class
    public Address getAddress() {   // and give it reference to column in Address.entity-> with name "address_id"
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @ManyToMany  // Many employees joined to many projects. We have to make a new table for it.
    @JoinTable(name = "employees_projects",     // We create first column with name "employee_id" and give it reference to Employee.entity. (column "employee_id"
            joinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "project_id")) // we create the second column with name "project_id"
    public Set<Project> getProjects() {                                                               // and give it reference to Project.entity.(column "project_id")
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
}
