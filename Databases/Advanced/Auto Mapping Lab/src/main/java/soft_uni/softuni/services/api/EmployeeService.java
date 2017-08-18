package soft_uni.softuni.services.api;

import soft_uni.softuni.model.Employee;

import java.util.Date;
import java.util.List;

public interface EmployeeService {

    public void registerEmployee(Employee employee);

    public List<Employee> findOlderEmployees(Date date);
}
