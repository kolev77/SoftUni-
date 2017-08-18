package soft_uni.softuni.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soft_uni.softuni.dao.EmployeeDao;
import soft_uni.softuni.model.Employee;
import soft_uni.softuni.services.api.EmployeeService;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public void registerEmployee(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public List<Employee> findOlderEmployees(Date date) {
        return employeeDao.findByBirthDateBeforeOrderBySalaryDesc(date);
    }
}
