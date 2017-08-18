package softuni.users.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.users.entities.Town;
import softuni.users.repositories.TownRepository;
import softuni.users.services.TownService;

@Service
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;

    @Autowired
    public TownServiceImpl(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    @Override
    public void persist(Town town) {
        this.townRepository.save(town);
    }
}
