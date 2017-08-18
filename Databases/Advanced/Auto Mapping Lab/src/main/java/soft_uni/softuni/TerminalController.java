package soft_uni.softuni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import soft_uni.softuni.dto.DTOMappingUtil;
import soft_uni.softuni.dto.EmployeeDto;
import soft_uni.softuni.dto.ManagerDto;
import soft_uni.softuni.model.Address;
import soft_uni.softuni.model.City;
import soft_uni.softuni.model.Employee;
import soft_uni.softuni.services.api.EmployeeService;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class TerminalController implements CommandLineRunner {
    private final EmployeeService employeeService;

    @Autowired
    public TerminalController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... strings) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        City city = new City("Varna");
        Address address = new Address(city);
        Employee e1 = new Employee("Ivan","Dimitrov", BigDecimal.valueOf(1300.12),sdf.parse("19780402"),address);
        EmployeeDto employeeDto = DTOMappingUtil.convert(e1,EmployeeDto.class);
        System.out.println(employeeDto);

        Employee e2 = DTOMappingUtil.convert(employeeDto,Employee.class);
        System.out.println(e2);

        Employee e3 = new Employee("Goshi","Dimitrov", BigDecimal.valueOf(5300.12),sdf.parse("19880302"),address);
        e3.addManagedEmployee(e1);
        e1.setManager(e3);
        employeeService.registerEmployee(e3);


        ManagerDto  managerDto = DTOMappingUtil.convert(e3,ManagerDto.class);
        System.out.println(managerDto);

        List<Employee> olderEmployees = employeeService.findOlderEmployees(sdf.parse("19900101"));
        List<EmployeeDto> olderEmployeesDtos = DTOMappingUtil.convertEmployeeList(olderEmployees, EmployeeDto.class);

        System.out.println(olderEmployeesDtos);
    }
}
