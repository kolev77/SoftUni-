package kolev.exam.services.api;

import kolev.exam.entities.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAllProductiveEmployees();
}
