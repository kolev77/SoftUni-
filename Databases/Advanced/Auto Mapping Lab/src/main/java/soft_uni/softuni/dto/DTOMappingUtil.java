package soft_uni.softuni.dto;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import soft_uni.softuni.model.Employee;

import java.util.ArrayList;
import java.util.List;

public final class DTOMappingUtil {
    private static ModelMapper mapper = new ModelMapper();

    private DTOMappingUtil() {
    }

    ;

    public static EmployeeDto convertEmployee(Employee employee) {
        return mapper.map(employee, EmployeeDto.class);
    }

    public static Employee convertEmployeeDTO(EmployeeDto employeeDto) {
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

    public static List<EmployeeDto> convertEmployeeList(List<Employee>sources, Class<EmployeeDto> dest) {
        PropertyMap<Employee,EmployeeDto> propMap = new PropertyMap<Employee, EmployeeDto>() {
            @Override
            protected void configure() {
                map().setManagerLastName(source.getManager().getLastName());
            }
        };
        mapper.addMappings(propMap);

        List<EmployeeDto> resultList = new ArrayList<>();
        for (Employee e : sources) {
            EmployeeDto d = convert(e, dest);
            resultList.add(d);
        }

        return resultList;
    }
}
