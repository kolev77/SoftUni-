package kolev.automapping.terminal;

import kolev.automapping.dto.DTOMappingUtil;
import kolev.automapping.dto.EmployeeDto;
import kolev.automapping.dto.ManagerDto;
import kolev.automapping.entities.Address;
import kolev.automapping.entities.City;
import kolev.automapping.entities.Employee;
import kolev.automapping.services.api.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class Terminal implements CommandLineRunner {

    private final EmployeeService employeeService;

    @Autowired
    public Terminal(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... strings) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Address address  = new Address(new City("Varna"));
        Employee e1 = new Employee("Ivan","Dimitrov", BigDecimal.valueOf(5400),sdf.parse("19670304"),address);
        Employee e2 = new Employee("Pesho","Ivanov", BigDecimal.valueOf(2400),sdf.parse("19970304"),address);
        e1.addManagedEmplyee(e2);
        e2.setManager(e1);
        EmployeeDto employeeDto = DTOMappingUtil.convertEmployee(e1);
        ManagerDto e3 = DTOMappingUtil.convert(e1,ManagerDto.class);
        EmployeeDto e4 = DTOMappingUtil.convert(e2,EmployeeDto.class);

        employeeService.registerEmployee(e1);
        List<Employee> olderEmployees = employeeService.findOlderEmployees(sdf.parse("19990101"));

        List<EmployeeDto> employeeDtos = DTOMappingUtil.convertEmployeeList(olderEmployees, EmployeeDto.class);
        System.out.println("asd");
    }
}
