package soft_uni.softuni.dto;

import soft_uni.softuni.model.Employee;

import java.util.Set;

public class ManagerDto {
    private String firstName;

    private String lastName;

    private Set<EmployeeDto>managedEmployees;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<EmployeeDto> getManagedEmployees() {
        return managedEmployees;
    }

    public void setManagedEmployees(Set<EmployeeDto> managedEmployees) {
        this.managedEmployees = managedEmployees;
    }

    @Override
    public String toString() {
        return "ManagerDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", managedEmployees=" + managedEmployees +
                '}';
    }
}
