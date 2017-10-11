package kolev.automapping.dto;

import kolev.automapping.entities.Employee;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class DTOMappingUtil {
    private DTOMappingUtil() {
    }

    ;
    private static ModelMapper mapper = new ModelMapper();

    public static EmployeeDto convertEmployee(Employee employee) {
        return mapper.map(employee, EmployeeDto.class);
    }

    public static Employee convertEmployeeDto(EmployeeDto employeeDto) {
        return mapper.map(employeeDto, Employee.class);
    }

    public static <S, D> D convert(S source, Class<D> destClass) {
        return mapper.map(source, destClass);
    }

    public static <S, D> List<D> convert(Iterable<S> sources, Class<D> destClass) {
        List<D> resultList = new ArrayList<>();
        for (S s : sources) {
            D d = convert(s, destClass);
            resultList.add(d);
        }
        return resultList;
    }

    public static List<EmployeeDto> convertEmployeeList(List<Employee> employees, Class<EmployeeDto> dest) {
        PropertyMap<Employee, EmployeeDto> propertyMap = new PropertyMap<Employee, EmployeeDto>() {
            @Override
            protected void configure() {
                map().setManagerLastName(source.getManager().getLastName());
            }
        };
        mapper.addMappings(propertyMap);

        List<EmployeeDto> resultList = new ArrayList<>();
        for (Employee e : employees) {
            EmployeeDto d = convert(e, dest);
            resultList.add(d);
        }
        return resultList;
    }
}
