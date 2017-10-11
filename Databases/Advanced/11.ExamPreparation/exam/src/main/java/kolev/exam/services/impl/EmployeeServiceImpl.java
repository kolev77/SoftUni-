package kolev.exam.services.impl;

import kolev.exam.entities.Employee;
import kolev.exam.repositories.EmployeeRepository;
import kolev.exam.services.api.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAllProductiveEmployees() {
        return this.employeeRepository.findAllProductiveEmployees()
                .stream()
                .sorted((e1, e2) -> {
                    int result = (e1.getFirstName() + " " + e1.getLastName()).compareTo(e2.getFirstName() + " " + e2.getLastName());

                    if (result == 0) {
                        result = Integer.compare(e2.getPosition().length(), e1.getPosition().length());
                    }
                    return result;
                })
                .collect(Collectors.toList());
    }

}
