package kolev.automapping.services.impl;

import kolev.automapping.dao.EmployeeDao;
import kolev.automapping.entities.Employee;
import kolev.automapping.services.api.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
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
        return employeeDao.findAllByBirthdateBeforeOrderBySalaryDesc(date);
    }
}
