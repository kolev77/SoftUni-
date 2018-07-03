package entities.positions;

import enums.EmployeePosition;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Employee extends BaseEmployee {
    public Employee() {
        super.setPosition(EmployeePosition.EMPLOYEE);
    }
}