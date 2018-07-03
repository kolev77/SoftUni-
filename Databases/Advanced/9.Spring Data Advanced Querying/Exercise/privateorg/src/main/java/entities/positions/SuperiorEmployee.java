package entities.positions;

import entities.institutions.Department;
import enums.EmployeePosition;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class SuperiorEmployee extends BaseEmployee {

    private Department managedDepartment;

    public SuperiorEmployee() {
        this.setPosition(EmployeePosition.SUPERIOR);
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "managed_department_id")
    public Department getManagedDepartment() {
        return managedDepartment;
    }

    public void setManagedDepartment(Department managedDepartment) {
        this.managedDepartment = managedDepartment;
    }
}