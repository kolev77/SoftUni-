package kolev.exam.services.impl;

import kolev.exam.constants.ResultMessages;
import kolev.exam.entities.EmployeeCard;
import kolev.exam.repositories.EmployeeCardRepository;
import kolev.exam.services.api.EmployeeCardService;
import kolev.exam.services.api.TownService;
import kolev.exam.utils.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeCardServiceImpl implements EmployeeCardService {

    private static final String EMPLOYEE_CARD = "Employee Card";

    private final EmployeeCardRepository employeeCardRepository;

    @Autowired
    public EmployeeCardServiceImpl(EmployeeCardRepository employeeCardRepository) {
        this.employeeCardRepository = employeeCardRepository;
    }

    @Override
    public String add(EmployeeCard employeeCard) {
        String result;

        if (DataValidator.isValid(employeeCard) && ! cardExists(employeeCard)) {
            this.employeeCardRepository.save(employeeCard);
            result = String.format(ResultMessages.SUCCESSFUL,
                    EMPLOYEE_CARD,
                    employeeCard);
        } else {
            result = ResultMessages.ERROR;
        }

        return result;
    }

    @Override
    public EmployeeCard findByNumber(String number) {
        return employeeCardRepository.findByNumber(number);
    }

    private boolean cardExists(EmployeeCard employeeCard) {
        EmployeeCard duplicate = this.employeeCardRepository.findByNumber(employeeCard.getNumber());
        return duplicate != null;
    }

}
