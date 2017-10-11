package kolev.automapping.services.api;

import kolev.automapping.entities.Employee;

import java.util.Date;
import java.util.List;

public interface EmployeeService {
    public void registerEmployee(Employee employee);

    public List<Employee> findOlderEmployees(Date date);
}
