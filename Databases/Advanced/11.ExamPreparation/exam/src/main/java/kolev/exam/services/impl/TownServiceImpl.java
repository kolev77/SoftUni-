package kolev.exam.services.impl;

import kolev.exam.constants.ResultMessages;
import kolev.exam.entities.Town;
import kolev.exam.repositories.TownRepository;
import kolev.exam.services.api.EmployeeService;
import kolev.exam.services.api.TownService;
import kolev.exam.utils.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;

    @Autowired
    public TownServiceImpl(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    @Override
    public String add(Town town) {
        String result;

        if (DataValidator.isValid(town)) {
            this.townRepository.save(town);
            result = String.format(ResultMessages.SUCCESSFUL,
                    town.getClass().getSimpleName(),
                    town);
        } else {
            result = ResultMessages.ERROR;
        }

        return result;
    }

    @Override
    public Town findByName(String name) {
        return this.townRepository.findByName(name);
    }

}
