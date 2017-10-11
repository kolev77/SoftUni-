package kolev.springintro.serviceImpl;

import kolev.springintro.entities.Town;
import kolev.springintro.repositories.TownRepository;
import kolev.springintro.services.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
