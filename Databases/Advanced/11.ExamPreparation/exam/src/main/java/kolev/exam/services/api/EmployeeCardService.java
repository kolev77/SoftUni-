package kolev.exam.services.api;

import kolev.exam.entities.EmployeeCard;

public interface EmployeeCardService {
    String add(EmployeeCard employeeCard);
    EmployeeCard findByNumber(String number);
}
